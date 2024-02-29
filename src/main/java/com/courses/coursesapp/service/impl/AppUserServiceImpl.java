package com.courses.coursesapp.service.impl;

import com.courses.coursesapp.dto.AppUserDto;
import com.courses.coursesapp.entity.AppUser;
import com.courses.coursesapp.entity.RoleEntity;
import com.courses.coursesapp.exception.MyBadRequestException;
import com.courses.coursesapp.exception.BusinessException;
import com.courses.coursesapp.repository.AppUserRepository;
import com.courses.coursesapp.repository.RoleRepository;
import com.courses.coursesapp.service.AppUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<AppUserDto> getAllUsers() {
        List<AppUser> users = appUserRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, AppUserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public AppUserDto getUserById(Long id) {
        AppUser user = appUserRepository.findById(id)
                .orElseThrow(() -> {
                    throw new BusinessException("No user was found for id : " + id);
                });

        return modelMapper.map(user, AppUserDto.class);
    }

    @Override
    public AppUserDto createUser(AppUserDto userDto) {
        AppUser user = modelMapper.map(userDto, AppUser.class);

        Collection<RoleEntity> roles = new HashSet<>();
        RoleEntity userRole = roleRepository.findByName("USER");
        roles.add(userRole);

        user.setRoles(roles);
        appUserRepository.save(user);

        return modelMapper.map(user, AppUserDto.class);
    }

    @Override
    public AppUserDto updateUser(AppUserDto appUserDto, Long id) throws MyBadRequestException {
        AppUser user = appUserRepository.findById(id)
                .orElseThrow(() -> new MyBadRequestException("User not found with id : " + id));
        user.setFirstName(appUserDto.getFirstName());
        user.setLastName(appUserDto.getLastName());
        user.setEmail(appUserDto.getEmail());

        AppUser updatedUser = appUserRepository.save(user);

        return modelMapper.map(updatedUser, AppUserDto.class);
    }

    @Override
    public void deleteUser(Long id) throws MyBadRequestException {
        AppUser user = appUserRepository.findById(id)
                .orElseThrow(() -> new MyBadRequestException("User not found with id : " + id));

        appUserRepository.deleteById(id);

    }
}

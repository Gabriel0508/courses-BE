package com.courses.coursesapp.service;

import com.courses.coursesapp.dto.AppUserDto;
import com.courses.coursesapp.exception.MyBadRequestException;
import com.courses.coursesapp.repository.AppUserRepository;
import com.courses.coursesapp.repository.RoleRepository;
import com.courses.coursesapp.service.impl.AppUserServiceImpl;
import com.courses.coursesapp.utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;


import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AppUserServiceTest {

    @Mock
    private AppUserRepository appUserRepository;

    @InjectMocks
    private AppUserServiceImpl appUserService;

    @Mock
    private RoleRepository roleRepository;

    @Spy
    private ModelMapper modelMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllUsersTest() {

        when(appUserRepository.findAll()).thenReturn(TestUtils.getAllUsers());

        List<AppUserDto> appUserDtoList = appUserService.getAllUsers();

        assertThat(appUserDtoList.size()).isEqualTo(1);
        assertThat(appUserDtoList.get(0).getFirstName()).isEqualTo(TestUtils.getAppUserDto().getFirstName());
    }

    @Test
    void getUserById() {

        when(appUserRepository.findById(1L)).thenReturn(Optional.ofNullable(TestUtils.getAppUser()));

        AppUserDto appUserDto = appUserService.getUserById(1L);

        assertThat(appUserDto).isNotNull();
        assertThat(appUserDto.getFirstName()).isEqualTo(TestUtils.getAppUserDto().getFirstName());
    }

//    @Test
//    void createUser() {
//        when(modelMapper.map(TestUtils.getAppUserDto(), AppUser.class)).thenReturn(TestUtils.getAppUser());
//        when(modelMapper.map(TestUtils.getAppUser(), AppUserDto.class)).thenReturn(TestUtils.getAppUserDto());
//        when(roleRepository.findByName(any())).thenReturn(TestUtils.getRoles().stream().toList().get(0));
//        when(appUserRepository.save(any())).thenReturn(TestUtils.getAppUserDto());
//
//        final AppUserDto createdUser = appUserService.createUser(TestUtils.getAppUserDto());
//
//        assertThat(createdUser).isNotNull();
//    }

    @Test
    void updateUser() throws MyBadRequestException {

        when(appUserRepository.findById(1L)).thenReturn(Optional.ofNullable(TestUtils.getAppUser()));
        when(appUserRepository.save(any())).thenReturn(TestUtils.getAppUser());

        AppUserDto updatedAppUserDto = appUserService.updateUser(TestUtils.getAppUserDto(), 1L);
        assertThat(updatedAppUserDto).isNotNull();
        assertThat(updatedAppUserDto.getFirstName()).isEqualTo(TestUtils.getAppUser().getFirstName());
    }

    @Test
    void deleteUser() throws MyBadRequestException {

        when(appUserRepository.findById(1L)).thenReturn(Optional.ofNullable(TestUtils.getAppUser()));

        appUserService.deleteUser(1L);

        verify(appUserRepository).deleteById(1L);
    }
}

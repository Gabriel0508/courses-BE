package com.courses.coursesapp.service;

import com.courses.coursesapp.dto.AppUserDto;
import com.courses.coursesapp.exception.MyBadRequestException;

import java.util.List;

public interface AppUserService {
    List<AppUserDto> getAllUsers();
    AppUserDto getUserById(Long id);
    AppUserDto createUser(AppUserDto user);
    AppUserDto updateUser(AppUserDto appUserDto, Long id) throws MyBadRequestException;
    void deleteUser(Long id) throws MyBadRequestException;
}

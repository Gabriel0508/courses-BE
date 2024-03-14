package com.courses.coursesapp.utils;

import com.courses.coursesapp.dto.AppUserDto;
import com.courses.coursesapp.entity.AppUser;
import com.courses.coursesapp.entity.RoleEntity;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class TestUtils {

    public static AppUser getAppUser() {
        return AppUser.builder()
                .id(1L)
                .firstName("Pop")
                .lastName("Andrei")
                .email("pop_andrei@gmail.com")
                .password("password123")
                .roles(getRoles())
                .build();
    }

    public static AppUserDto getAppUserDto() {
        return AppUserDto.builder()
                .id(1L)
                .firstName("Pop")
                .lastName("Andrei")
                .email("pop_andrei@gmail.com")
                .roles(getRoles())
                .build();
    }

    public static Collection<RoleEntity> getRoles() {
        HashSet<RoleEntity> roles = new HashSet<>();
        RoleEntity roleEntity = RoleEntity.builder()
                .id(1L)
                .name("USER")
                .build();

        roles.add(roleEntity);

        return roles;
    }

    public static List<AppUser> getAllUsers() {
        return List.of(getAppUser());
    }
}

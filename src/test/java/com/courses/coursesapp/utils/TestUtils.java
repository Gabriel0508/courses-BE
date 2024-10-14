package com.courses.coursesapp.utils;

import com.courses.coursesapp.dto.AppUserDto;
import com.courses.coursesapp.dto.CourseDto;
import com.courses.coursesapp.dto.UserCourseDto;
import com.courses.coursesapp.entity.AppUser;
import com.courses.coursesapp.entity.Course;
import com.courses.coursesapp.entity.RoleEntity;
import com.courses.coursesapp.entity.UserCourse;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public class TestUtils {

    public static AppUser getAppUser() {
        return AppUser.builder()
                .id(1L)
                .firstName("Pop")
                .lastName("Andrei")
                .email("pop_andrei@gmail.com")
                .password("password123")
                .roles(getRoles()) //Works here
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

    public static Collection<RoleEntity> isgetRoles() {
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

    public static Course getCourse() {
        return Course.builder()
                .id(1L)
                .name("English")
                .description("Advanced")
                .isEnabled(true)
                .type("pdf")
                .owner(getAppUser())
                .build();
    }

    public static List<Course> getAllCourses() {
        return List.of(getCourse());
    }

    public static CourseDto getCourseDto() {
        return CourseDto.builder()
                .id(1L)
                .name("English")
                .description("Advanced")
                .isEnabled(true)
                .type("pdf")
                .owner(getAppUserDto())
                .build();
    }
    public static UserCourse getUserCourse() {
        return UserCourse.builder()
                .id(1L)
                .course(getCourse())
                .user(getAppUser())
                .isFavourite(false)
                .isSubscribed(false)
                .isDone(false)
                .build();
    }
    public static Optional<UserCourse> getOptionalUserCourse() {
        return Optional.ofNullable(UserCourse.builder()
                .id(1L)
                .course(getCourse())
                .user(getAppUser())
                .isFavourite(false)
                .isSubscribed(false)
                .isDone(false)
                .build());
    }

    public static UserCourseDto getUserCourseDto() {
        return UserCourseDto.builder()
                .id(1L)
                .course(getCourseDto())
                .user(getAppUserDto())
                .isFavourite(false)
                .isSubscribed(false)
                .isDone(false)
                .build();
    }
    public static List<UserCourse> getUserCourseList() {
        return List.of(getUserCourse());
    }
}

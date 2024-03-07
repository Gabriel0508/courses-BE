package com.courses.coursesapp.service;

import com.courses.coursesapp.dto.AppUserDto;
import com.courses.coursesapp.dto.UserCourseDto;
import com.courses.coursesapp.exception.MyBadRequestException;

import java.util.List;

public interface UserCourseService {
    List<AppUserDto> getUsersByCourse(Long courseId);
    UserCourseDto assignUserToCourse(Long userId,Long courseId);
    UserCourseDto updateUserAssignedToCourse(UserCourseDto userCourseDto) throws MyBadRequestException;
    void deleteUserAssignment(Long id) throws MyBadRequestException;
}

package com.courses.coursesapp.service;

import com.courses.coursesapp.dto.CourseDto;
import com.courses.coursesapp.exception.MyBadRequestException;

import java.util.List;

public interface CourseService {
    List<CourseDto> getAllCourses();
    CourseDto getCourseById(Long id);
    CourseDto createCourse(CourseDto courseDto);
    CourseDto updateCourse(CourseDto courseDto, Long id) throws MyBadRequestException;
    void deleteCourse(Long id) throws MyBadRequestException;
    byte[] getImageForCourse(Long courseId);

}

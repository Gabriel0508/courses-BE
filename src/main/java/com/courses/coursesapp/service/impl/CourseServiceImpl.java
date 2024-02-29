package com.courses.coursesapp.service.impl;

import com.courses.coursesapp.dto.CourseDto;
import com.courses.coursesapp.entity.AppUser;
import com.courses.coursesapp.entity.Course;
import com.courses.coursesapp.exception.MyBadRequestException;
import com.courses.coursesapp.exception.BusinessException;
import com.courses.coursesapp.repository.CourseRepository;
import com.courses.coursesapp.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CourseDto> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream()
                .map(course -> modelMapper.map(course, CourseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CourseDto getCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> {
                    throw new BusinessException("No course was found for id : " + id);
                });

        return modelMapper.map(course, CourseDto.class);
    }

    @Override
    public CourseDto createCourse(CourseDto courseDto) {
        Course course = modelMapper.map(courseDto, Course.class);

        courseRepository.save(course);
        return modelMapper.map(course, CourseDto.class);
    }

    @Override
    public CourseDto updateCourse(CourseDto courseDto, Long id) throws MyBadRequestException {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new MyBadRequestException("Course not found with id : " + id));
        course.setName(courseDto.getName());
        course.setDescription(courseDto.getDescription());
        course.setIsEnabled(courseDto.getIsEnabled());
        course.setType(courseDto.getType());
        course.setOwner(modelMapper.map(courseDto.getOwner(),AppUser.class));

        Course updatedCourse = courseRepository.save(course);

        return modelMapper.map(updatedCourse, CourseDto.class);
    }

    @Override
    public void deleteCourse(Long id) throws MyBadRequestException {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new MyBadRequestException("Course not found with id : " + id));

        courseRepository.deleteById(id);
    }
}

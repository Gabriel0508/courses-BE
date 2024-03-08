package com.courses.coursesapp.service.impl;

import com.courses.coursesapp.dto.AppUserDto;
import com.courses.coursesapp.dto.UserCourseDto;
import com.courses.coursesapp.entity.AppUser;
import com.courses.coursesapp.entity.Course;
import com.courses.coursesapp.entity.UserCourse;
import com.courses.coursesapp.exception.MyBadRequestException;
import com.courses.coursesapp.repository.AppUserRepository;
import com.courses.coursesapp.repository.CourseRepository;
import com.courses.coursesapp.repository.UserCourseRepository;
import com.courses.coursesapp.service.UserCourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserCourseServiceImpl implements UserCourseService {

    @Autowired
    private UserCourseRepository userCourseRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<AppUserDto> getUsersByCourse(Long courseId) {
        return userCourseRepository.findByCourseId(courseId).stream()
                .map(userCourse -> modelMapper.map(userCourse, UserCourseDto.class))
                .map(userCourseDto -> userCourseDto.getUser())
                .collect(Collectors.toList());
    }

    @Override
    public UserCourseDto assignUserToCourse(Long userId, Long courseId) throws MyBadRequestException {

        UserCourse userCourse = new UserCourse();

        AppUser appUser = appUserRepository.findById(userId).orElseThrow(() -> new MyBadRequestException("User not found with id : " + userId));
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new MyBadRequestException("Course not found with id : " + courseId));
        userCourse.setCourse(course);
        userCourse.setUser(appUser);

        UserCourse savedUserCourse = userCourseRepository.save(userCourse);

        return modelMapper.map(savedUserCourse, UserCourseDto.class);
    }

    @Override
    public UserCourseDto updateUserAssignedToCourse(UserCourseDto userCourseDto) throws MyBadRequestException {
        return null;
    }

    @Override
    public void deleteUserAssignment(Long id) throws MyBadRequestException {

    }
}

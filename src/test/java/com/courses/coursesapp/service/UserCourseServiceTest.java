package com.courses.coursesapp.service;

import com.courses.coursesapp.dto.AppUserDto;
import com.courses.coursesapp.dto.UserCourseDto;
import com.courses.coursesapp.exception.MyBadRequestException;
import com.courses.coursesapp.repository.AppUserRepository;
import com.courses.coursesapp.repository.CourseRepository;
import com.courses.coursesapp.repository.UserCourseRepository;
import com.courses.coursesapp.service.impl.UserCourseServiceImpl;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserCourseServiceTest {

    @Mock
    private CourseRepository courseRepository;

    @Mock
    private UserCourseRepository userCourseRepository;

    @InjectMocks
    private UserCourseServiceImpl userCourseService;

    @Mock
    private AppUserRepository appUserRepository;

    @Spy
    private ModelMapper modelMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getUsersByCourse() {
        when(userCourseRepository.findByCourseId(any())).thenReturn((TestUtils.getUserCourseList()));

        final List<AppUserDto> users = userCourseService.getUsersByCourse(1L);

        assertThat(users).isNotNull();
    }
//    @Test
//    void assignUserToCourse() throws MyBadRequestException {
//        when(appUserRepository.findById(any())).thenReturn(Optional.ofNullable(TestUtils.getAppUser()));
//        when(courseRepository.findById(any())).thenReturn(Optional.ofNullable(TestUtils.getCourse()));
//        when(userCourseRepository.save(any())).thenReturn(TestUtils.getOptionalUserCourse());
//
//        final UserCourseDto createdUserCourse = userCourseService.assignUserToCourse(1L, 1L);
//
//        assertThat(createdUserCourse).isNotNull();
//    }

}

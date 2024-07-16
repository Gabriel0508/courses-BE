package com.courses.coursesapp.service;

import com.courses.coursesapp.dto.CourseDto;
import com.courses.coursesapp.exception.MyBadRequestException;
import com.courses.coursesapp.repository.AppUserRepository;
import com.courses.coursesapp.repository.CourseRepository;
import com.courses.coursesapp.service.impl.CourseServiceImpl;
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
public class CourseServiceTest {

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseServiceImpl courseService;

    @Mock
    private AppUserRepository appUserRepository;

    @Spy
    private ModelMapper modelMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllCoursesTest() {

        when(courseRepository.findAll()).thenReturn(TestUtils.getAllCourses());

        List<CourseDto> allCourses = courseService.getAllCourses();

        assertThat(allCourses.size()).isEqualTo(1);
        assertThat(allCourses.get(0).getDescription()).isEqualTo(TestUtils.getCourse().getDescription());
    }

    @Test
    void getCourseById() {

        when(courseRepository.findById(1L)).thenReturn(Optional.ofNullable(TestUtils.getCourse()));

        CourseDto course = courseService.getCourseById(1L);

        assertThat(course).isNotNull();
        assertThat(course.getDescription()).isEqualTo(TestUtils.getCourse().getDescription());
    }

//    @Test
//    void createCourse() {
//        when(appUserRepository.findById(any())).thenReturn(Optional.ofNullable(TestUtils.getAppUser()));
//        when(courseRepository.save(any())).thenReturn(TestUtils.getCourseDto());
//
//        final CourseDto createdCourse = courseService.createCourse(TestUtils.getCourseDto());
//
//        assertThat(createdCourse).isNotNull();
//    }

    @Test
    void updateCourse() throws MyBadRequestException {

        when(courseRepository.findById(1L)).thenReturn(Optional.ofNullable(TestUtils.getCourse()));
        when(courseRepository.save(any())).thenReturn(TestUtils.getCourse());

        CourseDto updatedCourseDto = courseService.updateCourse(TestUtils.getCourseDto(), 1L);
        assertThat(updatedCourseDto).isNotNull();
        assertThat(updatedCourseDto.getDescription()).isEqualTo(TestUtils.getCourse().getDescription());
    }

    @Test
    void deleteCourse() throws MyBadRequestException {

        when(courseRepository.findById(1L)).thenReturn(Optional.ofNullable(TestUtils.getCourse()));

        courseService.deleteCourse(1L);

        verify(courseRepository).deleteById(1L);
    }
}

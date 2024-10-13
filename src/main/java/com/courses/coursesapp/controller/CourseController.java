package com.courses.coursesapp.controller;

import com.courses.coursesapp.dto.CourseDto;
import com.courses.coursesapp.exception.MyBadRequestException;
import com.courses.coursesapp.service.CourseService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<List<CourseDto>> getAllCourses() {
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable("id") Long id) throws BadRequestException, IllegalAccessException {

        CourseDto courseDto = courseService.getCourseById(id);

        HttpStatus status = !ObjectUtils.isEmpty(courseDto) ? HttpStatus.OK : HttpStatus.NO_CONTENT;
        return new ResponseEntity<>(courseDto, status);
    }

    @PostMapping
    public ResponseEntity<CourseDto> createCourse(@RequestBody CourseDto courseDto) {
        CourseDto dto = courseService.createCourse(courseDto);

        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<CourseDto> updateCourse(@RequestBody CourseDto courseDto, @PathVariable("id") Long userId) throws MyBadRequestException {
        CourseDto updatedCourse = courseService.updateCourse(courseDto, userId);
        return ResponseEntity.ok(updatedCourse);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable("id") Long courseId) throws MyBadRequestException {
        courseService.deleteCourse(courseId);
        return ResponseEntity.ok("Course deleted successfully!");
    }

    @GetMapping(value = "/image/{courseId}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImageForCourse(@PathVariable Long courseId) {
        return ResponseEntity.ok(courseService.getImageForCourse(courseId));
    }
}

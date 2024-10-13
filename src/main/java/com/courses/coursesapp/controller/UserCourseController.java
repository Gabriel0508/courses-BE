package com.courses.coursesapp.controller;

import com.courses.coursesapp.dto.AppUserDto;
import com.courses.coursesapp.dto.UserCourseDto;
import com.courses.coursesapp.exception.MyBadRequestException;
import com.courses.coursesapp.service.UserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/courseAssign")
public class UserCourseController {

    @Autowired
    private UserCourseService userCourseService;

    @GetMapping("/{courseId}")
    public ResponseEntity<List<AppUserDto>> getAllUsersByCourseId(@PathVariable("courseId") Long courseId) {
        return new ResponseEntity<>(userCourseService.getUsersByCourse(courseId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserCourseDto> assignUserToCourse (@RequestParam (name="userId") Long userId, @RequestParam (name="courseId") Long courseId) throws MyBadRequestException {

            UserCourseDto dto = userCourseService.assignUserToCourse(userId,courseId);

        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<?> getCourseById(@PathVariable("id") Long id) throws BadRequestException, IllegalAccessException {
//
//        CourseDto courseDto = userCourseService.getCourseById(id);
//
//        HttpStatus status = !ObjectUtils.isEmpty(courseDto) ? HttpStatus.OK : HttpStatus.NO_CONTENT;
//        return new ResponseEntity<>(courseDto, status);
//    }
//
//    @PostMapping
//    public ResponseEntity<CourseDto> createCourse(@RequestBody CourseDto courseDto) {
//        CourseDto dto = userCourseService.createCourse(courseDto);
//
//        return new ResponseEntity<>(dto, HttpStatus.CREATED);
//    }
//
//    @PutMapping("{id}")
//    public ResponseEntity<CourseDto> updateCourse(@RequestBody CourseDto courseDto, @PathVariable("id") Long userId) throws MyBadRequestException {
//        CourseDto updatedCourse = userCourseService.updateCourse(courseDto, userId);
//        return ResponseEntity.ok(updatedCourse);
//    }
//
//    @DeleteMapping("{id}")
//    public ResponseEntity<String> deleteCourse(@PathVariable("id") Long courseId) throws MyBadRequestException {
//        userCourseService.deleteCourse(courseId);
//        return ResponseEntity.ok("Course deleted successfully!");
//    }
//
//    @GetMapping(value = "/image/{courseId}", produces = MediaType.IMAGE_JPEG_VALUE)
//    public ResponseEntity<byte[]> getImageForCourse(@PathVariable Long courseId) {
//        return ResponseEntity.ok(userCourseService.getImageForCourse(courseId));
//    }
}

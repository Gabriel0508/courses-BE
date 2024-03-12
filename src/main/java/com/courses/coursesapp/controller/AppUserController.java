package com.courses.coursesapp.controller;

import com.courses.coursesapp.dto.AppUserDto;
import com.courses.coursesapp.exception.MyBadRequestException;
import com.courses.coursesapp.service.AppUserService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @GetMapping
    public ResponseEntity<List<AppUserDto>> getAllUsers() {
        return new ResponseEntity<>(appUserService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAppUserById(@PathVariable("id") Long id) throws BadRequestException, IllegalAccessException {

        AppUserDto userDto = appUserService.getUserById(id);

        HttpStatus status = !ObjectUtils.isEmpty(userDto) ? HttpStatus.OK : HttpStatus.NO_CONTENT;
        return new ResponseEntity<>(userDto, status);
    }

    @PostMapping
    public ResponseEntity<AppUserDto> createUser(@RequestBody AppUserDto appUserDto) {
        AppUserDto userDto = appUserService.createUser(appUserDto);

        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<AppUserDto> updateUser(@RequestBody AppUserDto appUserDto, @PathVariable("id") Long userId) throws MyBadRequestException {
        AppUserDto updatedUser = appUserService.updateUser(appUserDto, userId);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) throws MyBadRequestException {
        appUserService.deleteUser(userId);
        return ResponseEntity.ok("User deleted successfully!");
    }

}

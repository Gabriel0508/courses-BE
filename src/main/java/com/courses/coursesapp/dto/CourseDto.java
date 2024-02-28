package com.courses.coursesapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CourseDto {
    private Long id;
    private String name;
    private String description;
    private Boolean isEnabled;
    private String type;
    private AppUserDto owner;
}

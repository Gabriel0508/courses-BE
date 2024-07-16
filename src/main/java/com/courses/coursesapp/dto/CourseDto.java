package com.courses.coursesapp.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class CourseDto {
    private Long id;
    private String name;
    private String description;
    private Boolean isEnabled;
    private String type;
    private AppUserDto owner;
    private String image;
}

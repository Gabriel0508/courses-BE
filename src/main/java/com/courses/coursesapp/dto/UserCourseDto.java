package com.courses.coursesapp.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class UserCourseDto {
    private Long id;
    private AppUserDto user;
    private CourseDto course;
    private Boolean isFavourite;
    private Boolean isSubscribed;
    private Boolean isDone;
}

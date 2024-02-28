package com.courses.coursesapp.dto;

import com.courses.coursesapp.entity.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AppUserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Collection<RoleEntity> roles;
}

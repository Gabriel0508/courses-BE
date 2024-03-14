package com.courses.coursesapp.dto;

import com.courses.coursesapp.entity.RoleEntity;
import lombok.*;

import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class AppUserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Collection<RoleEntity> roles;
}

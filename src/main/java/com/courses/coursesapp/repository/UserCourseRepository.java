package com.courses.coursesapp.repository;

import com.courses.coursesapp.entity.UserCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCourseRepository extends JpaRepository<UserCourse, Long> {

    List<UserCourse> findByCourseId(Long id);
}

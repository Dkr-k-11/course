package com.coursehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.coursehub.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
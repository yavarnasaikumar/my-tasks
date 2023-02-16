package com.saikumar.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saikumar.entity.Course;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByFeeLessThan(double fee);
}

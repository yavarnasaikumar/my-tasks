package com.saikumar.ManyToMany.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saikumar.ManyToMany.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

	List<Course>findByCourseFeeLessThan(Long courseFee);
}

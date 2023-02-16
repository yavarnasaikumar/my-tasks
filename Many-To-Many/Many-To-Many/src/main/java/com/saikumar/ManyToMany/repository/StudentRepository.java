package com.saikumar.ManyToMany.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saikumar.ManyToMany.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	List<Student> findByStudentNameContaining(String studentName);
}

package com.saikumar.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saikumar.entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findByNameContaining(String name);
}

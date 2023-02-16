package com.saikumar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saikumar.entity.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Integer> {
	
}

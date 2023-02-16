package com.saikumar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saikumar.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}

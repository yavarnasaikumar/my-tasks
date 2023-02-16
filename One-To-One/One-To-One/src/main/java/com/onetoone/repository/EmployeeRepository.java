package com.onetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.onetoone.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

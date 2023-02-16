package com.saikumar.dbToExcel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saikumar.dbToExcel.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}

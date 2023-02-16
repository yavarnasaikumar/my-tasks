package com.onetoone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onetoone.entity.Employee;
import com.onetoone.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository empRepo;
	
	@PostMapping("/saveEmployees")
	public ResponseEntity<String> saveEmployees(@RequestBody List<Employee> empData) {
		empRepo.saveAll(empData);
		return ResponseEntity.ok("Data saved");
	}
	
	@GetMapping("/getEmployees")
	public List<Employee> getEmployees() {
		return empRepo.findAll();
	}
	
	@SuppressWarnings("deprecation")
	@GetMapping("/getEmployee/{empId}")
	public Employee getEmployee(@PathVariable Long empId) {
		return empRepo.getOne(empId);
	}
}

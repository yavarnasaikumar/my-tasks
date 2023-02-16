package com.saikumar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saikumar.entity.Employee;
import com.saikumar.repository.EmployeeRepository;

@RestController
@CrossOrigin(origins = "http://localhost:8080/onetomany")
public class EmployeeController {

	@Autowired
	private EmployeeRepository empRepo; 
	
	@PostMapping("/saveEmployees")
	public ResponseEntity<String> saveEmployees(@RequestBody Employee employee) {
		empRepo.save(employee);
		return ResponseEntity.ok("Data saved");
	}
	
	@GetMapping("/getEmployees")
	public List<Employee> getEmployees() {
		return empRepo.findAll();
	}
	
	@GetMapping("/getEmployees/{empId}")
	public Employee getEmployeeById(@PathVariable Long empId) {
		return empRepo.findById(empId).orElse(null);
	}
	
}

package com.saikumar.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.saikumar.entity.Employee;
import com.saikumar.services.EmpServices;
import com.saikumar.services.ExcelServices;

@RestController
@CrossOrigin
public class Controller {

	@Autowired
	private EmpServices empServices;
	
	@PostMapping("/employee/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
		if(ExcelServices.checkExcelForamt(file)) {
			this.empServices.save(file);
			return ResponseEntity.ok(Map.of("message", " File is uploaded and data is saved to db"));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file");
	}
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployeeById(@RequestParam("file") MultipartFile file) {
		return this.empServices.getEmpId(file);
	}
	
	@GetMapping("/getEmployees")
	public List<Employee> getAllEmployees() {
		return this.empServices.getAllEmployees();
	}
	
//	@GetMapping("/employee/{empId}")
//	public List<Employee> getEmployeeByEmpId(@PathVariable Integer empId) {
//		
//		return this.getEmployeeByEmpId(empId);
//	}
	
//	@GetMapping("/employee/{empGovtId}")
//	public List<Employee> getEmployeeByEmpGovtId(@PathVariable int empGovtId) {
//		
//		return this.getEmployeeByEmpGovtId(empGovtId);
//	}
	
//	@GetMapping("/employee/{empName}")
//	public List<Employee> getAllEmpWithName(@PathVariable String empName) {
//		
//		return this.getAllEmpWithName(empName);
//	}
	
//	@GetMapping("/employee/{empId}")
//	public Employee getEmpById(@PathVariable int empId) {
//		return this.getEmpById(empId);
//	}
}

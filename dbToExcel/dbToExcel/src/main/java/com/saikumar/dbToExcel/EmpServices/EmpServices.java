package com.saikumar.dbToExcel.EmpServices;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.saikumar.dbToExcel.Entity.Employee;
import com.saikumar.dbToExcel.ExcelServices.ExcelServices;
import com.saikumar.dbToExcel.Repository.EmployeeRepository;

@Service
public class EmpServices {
	
	@Autowired
	private EmployeeRepository empRepo;

	public void save(MultipartFile file) {
		
		try {
			List<Employee> employees = ExcelServices.convertExcelToList(file.getInputStream());
			this.empRepo.saveAll(employees);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Employee> getAllEmployees() {
		
		return this.empRepo.findAll();
	}
	
	public List<Employee> getAllEmpWithName() {
		return this.getAllEmpWithName();
	}
	
	public Employee getEmpById(Integer empId) {
		return this.empRepo.findById(empId).get();
	}
	
}

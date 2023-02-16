package com.saikumar.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.saikumar.entity.Employee;
import com.saikumar.repository.EmployeeRepository;

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
	
	public List<Employee> getEmpId(MultipartFile file) {
		
		try {
			List<Integer> empIdList = ExcelServicesForQuiry.getingEmpId(file.getInputStream());
			return this.empRepo.findAllById(empIdList);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Employee> getAllEmployees() {
		return this.empRepo.findAll();
	}
	
	public List<Employee> getAllEmpWithName() {
		return this.getAllEmpWithName();
	}
	
	public Employee getEmpbyEmpGovtId() {
		return this.getEmpbyEmpGovtId();
	}
	
	public Employee getEmpById(Integer empId) {
		return this.empRepo.findById(empId).get();
	}
	
}

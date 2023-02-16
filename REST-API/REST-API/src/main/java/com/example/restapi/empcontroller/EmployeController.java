package com.example.restapi.empcontroller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.empservices.EmployeServices;
import com.example.restapi.entity.Employe;

@RestController
public class EmployeController {

	@Autowired
	private EmployeServices empServices;
	
	@GetMapping("/getEmployes")
	public List<Employe> getAll() {
		return empServices.listAll();  
	}
	
	@GetMapping("/getEmploye/{empId}")
	public ResponseEntity<Employe> getEmployeById(@PathVariable Integer empId) {
		//return empServices.getEmpById(empId);
		
		try {
	        Employe employe = empServices.getEmpById(empId);
	        return new ResponseEntity<Employe>(employe, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Employe>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@DeleteMapping("/deleteEmploye/{empId}")
	public void deleteEmployeById(@PathVariable Integer empId) {
		empServices.deleteEmpById(empId); 
	}
	
	@PostMapping("/saveEmploye")
	public void saveEmploye(@RequestBody Employe employe) {
		empServices.saveEmploye(employe);
	}
	
//	@PutMapping("/editEmploye/{empGovtId}")
//	public ResponseEntity<?> update(@RequestBody Employe employe, @PathVariable Integer empGovtId) {
//	    try {
//	        Employe existEmploye = empServices.getEmpByGovtId(empGovtId);
//	        empServices.saveEmploye(employe);
//	        return new ResponseEntity<>(HttpStatus.OK);
//	    } catch (NoSuchElementException e) {
//	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	    }      
//	}
//	
//	@PutMapping("/editEmployeById/{empId}")
//	public ResponseEntity<?> updateById(@RequestBody Employe employe, @PathVariable Integer empId) {
//	    try {
//	        Employe existEmploye = empServices.getEmpById(empId);
//	        empServices.saveEmploye(employe);
//	        return new ResponseEntity<>(HttpStatus.OK);
//	    } catch (NoSuchElementException e) {
//	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	    }      
//	}
	
	@PutMapping("/getEmp/{empId}")
	public ResponseEntity<?> updateEmpById(@PathVariable Integer empId, @RequestBody Employe employe) {
		empServices.updateEmploye(empId, employe);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}

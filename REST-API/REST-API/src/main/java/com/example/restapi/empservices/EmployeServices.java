package com.example.restapi.empservices;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restapi.entity.Employe;
import com.example.restapi.repo.EmployeRepository;

@Service
public class EmployeServices {
	
	@Autowired
	private EmployeRepository employeRepo;
	
	public List<Employe> listAll() {
        return employeRepo.findAll();
    }
     
    public void saveEmploye(Employe employe) {
    	employeRepo.save(employe);
    }
     
    public Employe getEmpById(Integer empId) {
        return employeRepo.findById(empId).get();
    }
     
    public void deleteEmpById(Integer empId) {
    	employeRepo.deleteById(empId);
    }
    
//    public Employe getEmpByGovtId(Integer empGovtId) {
//        return employeRepo.findByEmpGovtId(empGovtId);
//    }
    
    public Employe updateEmploye(Integer empId, Employe employe) {
    	if(employeRepo.findById(empId).isPresent()) {
    		Employe existingEmploye = employeRepo.findById(empId).get();
    		
    		existingEmploye.setUpdatedAt(new Date(System.currentTimeMillis()));
    		existingEmploye.setEmpId(empId);
    		existingEmploye.setEmpDoj(employe.getEmpDoj());
    		existingEmploye.setCreatedAt(employe.getCreatedAt());
    		existingEmploye.setEmpDol(employe.getEmpDol());
    		existingEmploye.setEmpFirstName(employe.getEmpFirstName());
    		existingEmploye.setEmpLastName(employe.getEmpLastName());
    		existingEmploye.setEmpMail(employe.getEmpMail());
    		
    		Employe updatedEmploye = employeRepo.save(existingEmploye);
    		
    		return updatedEmploye;
    	}else {
    		return null;
    	}
    	
    }
    
}

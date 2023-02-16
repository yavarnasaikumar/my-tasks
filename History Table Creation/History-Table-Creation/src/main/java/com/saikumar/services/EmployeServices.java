package com.saikumar.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saikumar.entity.Employe;
import com.saikumar.entity.EmployeHistory;
import com.saikumar.repository.EmployeHistoryRepository;
import com.saikumar.repository.EmployeRepository;

@Service
public class EmployeServices {
	
	@Autowired
	private EmployeRepository employeRepo;
	
	@Autowired
	private EmployeHistoryRepository empHistoryRepo; 
	
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
    
    public Employe updateEmploye(Integer empId, Employe employe) {
    	if(employeRepo.findById(empId).isPresent()) {
    		Employe existingEmploye = employeRepo.findById(empId).get();
    		
    		EmployeHistory oldEmpData = new EmployeHistory();
    		
    		oldEmpData.setCreatedAt(existingEmploye.getCreatedAt());
    		oldEmpData.setEmpDoj(existingEmploye.getEmpDoj());
    		oldEmpData.setEmpDol(existingEmploye.getEmpDol());
    		oldEmpData.setEmpFirstName(existingEmploye.getEmpFirstName());
    		oldEmpData.setEmpLastName(existingEmploye.getEmpLastName());
    		oldEmpData.setEmpGovtId(existingEmploye.getEmpGovtId());
    		oldEmpData.setEmpId(empId);
    		oldEmpData.setEmpMail(existingEmploye.getEmpMail());
    		oldEmpData.setUpdatedAt(new Date(System.currentTimeMillis()));
    		
    		empHistoryRepo.save(oldEmpData);
    		
    		
    		
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
    
    public EmployeHistory getEmpHistoryById(Integer empId) {
        return empHistoryRepo.findById(empId).get();
    }
    
    public List<EmployeHistory> listAllEmpData() {
        return empHistoryRepo.findAll();
    }
    
}

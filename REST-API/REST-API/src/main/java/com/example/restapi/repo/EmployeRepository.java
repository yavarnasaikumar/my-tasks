package com.example.restapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restapi.entity.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Integer> {

//	public Employe findByEmpGovtId(Integer empGovtId);
//	public Employe updateEmployee(Integer empId, Employe employe);
}

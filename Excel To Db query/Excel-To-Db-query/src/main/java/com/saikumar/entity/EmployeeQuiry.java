package com.saikumar.entity;

import javax.persistence.Id;

public class EmployeeQuiry {
	
	@Id
	private Integer empId;

	public EmployeeQuiry(Integer empId) {
		super();
		this.empId = empId;
	}
	
	public EmployeeQuiry() {
		
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

}

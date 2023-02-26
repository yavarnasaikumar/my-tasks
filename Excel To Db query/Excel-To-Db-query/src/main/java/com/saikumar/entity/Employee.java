package com.saikumar.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee_quiry")
public class Employee {

	@Id
	private Integer empId;
	private String empFirstName;
	private String empLastName;
	private String empMail;
	private int empGovtId;

	public Employee(Integer empId, String empFirstName, String empLastName, String empMail, Integer empGovtId) {
		this.empId = empId;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.empMail = empMail;
		this.empGovtId = empGovtId;
	}
	
	public Employee() {
		
	}
	
	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpFirstName() {
		return empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	public String getEmpLastName() {
		return empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	public String getEmpMail() {
		return empMail;
	}

	public void setEmpMail(String empMail) {
		this.empMail = empMail;
	}

	public int getEmpGovtId() {
		return empGovtId;
	}

	public void setEmpGovtId(int empGovtId) {
		this.empGovtId = empGovtId;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empId + ", empFirstName=" + empFirstName + ", empLastName=" + empLastName
				+ ", empMail=" + empMail + ", empGovtId=" + empGovtId + "]";
	}
	
}

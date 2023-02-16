package com.saikumar.dbToExcel.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	private Integer empid;
	@Column
	private String empFirstName;
	@Column
	private String empLastName;
	@Column
	private String empMail;
	@Column
	private int empGovtId;

	public Employee(Integer empid, String empFirstName, String empLastName, String empMail, Integer empGovtId) {
		this.empid = empid;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.empMail = empMail;
		this.empGovtId = empGovtId;
	}
	
	public Employee() {
		
	}

	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empId) {
		this.empid = empId;
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
		return "Employee [empid=" + empid + ", empFirstName=" + empFirstName + ", empLastName=" + empLastName
				+ ", empMail=" + empMail + ", empGovtId=" + empGovtId + "]";
	}
	
}

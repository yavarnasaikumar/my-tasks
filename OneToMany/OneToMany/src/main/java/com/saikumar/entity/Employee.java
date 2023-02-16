package com.saikumar.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;

import lombok.Data;

@Entity
@Transactional
@Data
@Table(name="employee_details_many2")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emp_id")
	private Long empId;
	private String empName;
	private String empMail;
	private Integer empGovtId;
	
    @OneToMany(mappedBy = "employee")
	private List<Address> address;
	
	public Employee() {
		
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpMail() {
		return empMail;
	}

	public void setEmpMail(String empMail) {
		this.empMail = empMail;
	}

	public Integer getEmpGovtId() {
		return empGovtId;
	}

	public void setEmpGovtId(Integer empGovtId) {
		this.empGovtId = empGovtId;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

}

package com.onetoone.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Transactional
@Data
@Table(name="employee_details")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emp_id")
	private Long empId;
	private String empName;
	private String empCity;
	private String empMail;
	private Integer empGovtId;
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_comp_id")
    @JsonIgnore
	private CompanyDetails companydetails;
	
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

	public CompanyDetails getCompanyDetails() {
		return companydetails;
	}

	public void setCompanyDetails(CompanyDetails companyDetails) {
		this.companydetails = companyDetails;
	}

	public String getEmpCity() {
		return empCity;
	}

	public void setEmpCity(String empCity) {
		this.empCity = empCity;
	}

	public CompanyDetails getCompanydetails() {
		return companydetails;
	}

	public void setCompanydetails(CompanyDetails companydetails) {
		this.companydetails = companydetails;
	}
	
}

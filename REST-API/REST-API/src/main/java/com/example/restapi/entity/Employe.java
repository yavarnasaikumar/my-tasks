package com.example.restapi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "employe")
@EntityListeners(AuditingEntityListener.class)
public class Employe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empId;
	private String empFirstName;
	private String empLastName;
	private String empMail;
	private Integer empGovtId;
	
	private String empDoj;
	private String empDol;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@Column(name="created_at",updatable = false)
	private Date createdAt = new Date(System.currentTimeMillis());
	
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	@Column(name="updated_at",updatable = true)
	private Date updatedAt = new Date(System.currentTimeMillis());
	
	public Employe() {
		
	}

	public Employe(String empFirstName, String empLastName, String empMail, Integer empGovtId, String empDoj,
			String empDol, Date createdAt, Date updatedAt) {
		super();
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.empMail = empMail;
		this.empGovtId = empGovtId;
		this.empDoj = empDoj;
		this.empDol = empDol;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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

	public Integer getEmpGovtId() {
		return empGovtId;
	}

	public void setEmpGovtId(Integer empGovtId) {
		this.empGovtId = empGovtId;
	}

	public String getEmpDoj() {
		return empDoj;
	}

	public void setEmpDoj(String empDoj) {
		this.empDoj = empDoj;
	}

	public String getEmpDol() {
		return empDol;
	}

	public void setEmpDol(String empDol) {
		this.empDol = empDol;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}

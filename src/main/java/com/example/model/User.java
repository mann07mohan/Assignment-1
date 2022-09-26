package com.example.model;

import java.time.OffsetDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	protected int id;
	
	@Column(name="name")
	protected String name;
	
	@Column(name="salary")
	protected String salary;
	
	@Column(name="age")
	protected String age;
	
	@Column(name="gender")
	protected String gender;
	
	@Column(name="mobile_no")
	protected String mobile;
	
	@Column(name="status")
	protected String status;
	
	@Column(name="created_by")
	protected String createdBy;
	
	@Column(name="created_on")
	protected OffsetDateTime createdOn;
	
	@Column(name="modified_by")
	protected String modifiedBy;
	
	@Column(name="modified_on")
	protected OffsetDateTime modifiedOn;
	
	public User() {
	}

	public User(int id, String name, String salary, String age, String gender, String mobile, String status,
			String createdBy, OffsetDateTime createdOn, String modifiedBy, OffsetDateTime modifiedOn) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.gender = gender;
		this.mobile = mobile;
		this.status = status;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.modifiedBy = modifiedBy;
		this.modifiedOn = modifiedOn;
	}

	public User(String name, String salary, String age, String gender, String mobile, String status, String createdBy,
			OffsetDateTime createdOn, String modifiedBy, OffsetDateTime modifiedOn) {
		super();
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.gender = gender;
		this.mobile = mobile;
		this.status = status;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.modifiedBy = modifiedBy;
		this.modifiedOn = modifiedOn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public OffsetDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(OffsetDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public OffsetDateTime getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(OffsetDateTime modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	
	

	
	
}

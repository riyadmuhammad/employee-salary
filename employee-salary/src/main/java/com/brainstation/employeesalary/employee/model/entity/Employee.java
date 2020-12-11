package com.brainstation.employeesalary.employee.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "employee")
public class Employee implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "emp_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empId;
	
	@Column(name = "employee_custom_id",unique = true)
	private String employeeCustomId;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "grade_id")
	private Integer gradeId;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "mobile")
	private String mobile;

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmployeeCustomId() {
		return employeeCustomId;
	}

	public void setEmployeeCustomId(String employeeCustomId) {
		this.employeeCustomId = employeeCustomId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Integer getGradeId() {
		return gradeId;
	}

	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	

}

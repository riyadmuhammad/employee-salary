package com.brainstation.employeesalary.employee.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "basic_salary_lowest_range")
public class BasicSalaryLowestRange implements Serializable{
	
	private static final long serialVersionUID = 2205266225657520012L;
	

	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "lowest_basic_salary")
	private Double lowestBasicSalary;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getLowestBasicSalary() {
		return lowestBasicSalary;
	}

	public void setLowestBasicSalary(Double lowestBasicSalary) {
		this.lowestBasicSalary = lowestBasicSalary;
	}
	
	
	
	

}

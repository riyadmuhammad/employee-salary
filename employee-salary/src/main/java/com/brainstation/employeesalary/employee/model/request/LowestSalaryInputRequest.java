package com.brainstation.employeesalary.employee.model.request;

import javax.validation.constraints.NotNull;

public class LowestSalaryInputRequest {
	
	@NotNull
	private Long id;
	
	@NotNull
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

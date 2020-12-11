package com.brainstation.employeesalary.employee.model.response;

public class LowestSalaryViewResponse {
	
	private Long id;
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

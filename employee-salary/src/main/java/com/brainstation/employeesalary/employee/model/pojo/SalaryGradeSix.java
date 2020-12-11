package com.brainstation.employeesalary.employee.model.pojo;

public class SalaryGradeSix extends SalaryGrade{
	
	   public SalaryGradeSix(double lowestBasicSalary) {
			
			basic=lowestBasicSalary;
			houseRent=(basic*20)/100;
			medicalAllowance=(basic*15)/100;
			grossSalary=basic+houseRent+medicalAllowance;
			
		}
}

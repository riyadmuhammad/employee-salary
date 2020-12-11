package com.brainstation.employeesalary.employee.model.pojo;

public class SalaryGradeFive extends SalaryGrade{
	
   public SalaryGradeFive(double lowestBasicSalary) {
		
		basic=lowestBasicSalary+salaryIncreasingCalculation;
		houseRent=(basic*20)/100;
		medicalAllowance=(basic*15)/100;
		grossSalary=basic+houseRent+medicalAllowance;
		
	}

}

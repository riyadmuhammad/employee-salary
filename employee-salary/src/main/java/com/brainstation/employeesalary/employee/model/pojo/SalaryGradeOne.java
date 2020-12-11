package com.brainstation.employeesalary.employee.model.pojo;

public class SalaryGradeOne extends SalaryGrade{

	
	public SalaryGradeOne(double lowestBasicSalary) {
		
		basic=lowestBasicSalary+(salaryIncreasingCalculation*5);
		houseRent=(basic*20)/100;
		medicalAllowance=(basic*15)/100;
		grossSalary=basic+houseRent+medicalAllowance;
	}
}

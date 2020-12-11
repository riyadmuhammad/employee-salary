package com.brainstation.employeesalary.employee.model.pojo;

public class SalaryGradeThree extends SalaryGrade{
	
  public SalaryGradeThree(double lowestBasicSalary) {
		
		basic=lowestBasicSalary+(salaryIncreasingCalculation*3);
		houseRent=(basic*20)/100;
		medicalAllowance=(basic*15)/100;
		grossSalary=basic+houseRent+medicalAllowance;
		
	}

}

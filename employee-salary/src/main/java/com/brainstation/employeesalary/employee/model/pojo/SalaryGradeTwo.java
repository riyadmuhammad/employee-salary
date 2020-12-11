package com.brainstation.employeesalary.employee.model.pojo;

public class SalaryGradeTwo extends SalaryGrade{
	
   public SalaryGradeTwo(double lowestBasicSalary) {
		
		basic=lowestBasicSalary+(salaryIncreasingCalculation*4);
		houseRent=(basic*20)/100;
		medicalAllowance=(basic*15)/100;
		grossSalary=basic+houseRent+medicalAllowance;
		
	}

}

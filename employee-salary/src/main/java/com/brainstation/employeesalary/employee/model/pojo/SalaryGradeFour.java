package com.brainstation.employeesalary.employee.model.pojo;

public class SalaryGradeFour extends SalaryGrade{
	
      public SalaryGradeFour(double lowestBasicSalary) {
		
		basic=lowestBasicSalary+(salaryIncreasingCalculation*2);
		houseRent=(basic*20)/100;
		medicalAllowance=(basic*15)/100;
		grossSalary=basic+houseRent+medicalAllowance;
		
	}

}

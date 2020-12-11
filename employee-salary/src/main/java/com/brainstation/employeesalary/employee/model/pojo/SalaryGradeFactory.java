package com.brainstation.employeesalary.employee.model.pojo;

public class SalaryGradeFactory {
	
	private double lowestBasicSalary;
	
	
	
	public SalaryGrade findSalaryGrade(int gradeId) {
		
		SalaryGrade salaryGrade=null;
		
		switch(gradeId) {
		
		  case 1:
			  salaryGrade=new SalaryGradeOne(lowestBasicSalary);
		    break;
		    
		  case 2:
			  salaryGrade=new SalaryGradeTwo(lowestBasicSalary);
		    break;
		    
		  case 3:
			  salaryGrade=new SalaryGradeThree(lowestBasicSalary);
		    break;
		    
		  case 4:
			  salaryGrade=new SalaryGradeFour(lowestBasicSalary);
		    break;
		    
		  case 5:
			  salaryGrade=new SalaryGradeFive(lowestBasicSalary);
		    break;
		    
		  case 6:
			  salaryGrade=new SalaryGradeSix(lowestBasicSalary);
		    break;   
		   
		  default:
			  salaryGrade=new SalaryGradeOne(lowestBasicSalary);
		    
		}
		
		return salaryGrade;
		
	}
	

	public double getLowestBasicSalary() {
		return lowestBasicSalary;
	}

	public void setLowestBasicSalary(double lowestBasicSalary) {
		this.lowestBasicSalary = lowestBasicSalary;
	}
	
	
	
	
	
	

}

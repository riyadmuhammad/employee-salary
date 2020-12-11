package com.brainstation.employeesalary.common;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class PageController {
	
	

	
	  @GetMapping("/")
	  public String homePage() {
	      return "home";
	  }
	  
	 
	  
	  @GetMapping("/lowest-range-basic-salary")
	  public String lowestRangeBasicBalaryPage() {
	      return "lowest-range-basic-salary";
	  }
	  
	  
	  @GetMapping("/company-bank-account")
	  public String companyBankAccountPage() {
	      return "company-bank-account";
	  }
	  
	  
	  @GetMapping("/company-bank-balance-view")
	  public String companyBankBalanceViewPage() {
	      return "company-bank-balance-view";
	  }
	  
	  
	  @GetMapping("/employee-registration")
	  public String employeeRegistrationPage() {
	      return "employee-registration";
	  }
   
   
   
	  @GetMapping("/employee-list")
	  public String employeeListPage() {
	      return "employee-list";
	  }
	  
	  @GetMapping("/salary-sheet")
	  public String salarySheetPage() {
	      return "salary-sheet";
	  }
	  
	  @GetMapping("/salary-transffer")
	  public String salaryTransfferPage() {
	      return "salary-transffer";
	  }
	  
	  
	  @GetMapping("/salary-calculation")
	  public String salaryCalculationPage() {
	      return "salary-calculation";
	  }
   
    
	 

   
}

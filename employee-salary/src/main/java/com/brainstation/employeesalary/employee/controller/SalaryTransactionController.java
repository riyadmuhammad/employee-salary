package com.brainstation.employeesalary.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.brainstation.employeesalary.common.BaseResponse;
import com.brainstation.employeesalary.employee.service.SalaryTransactionService;

@Controller
public class SalaryTransactionController {
	
	@Autowired
	public SalaryTransactionService salaryTransactionService; 
	
	
	@GetMapping(value = "/transfer/salary")
	public ResponseEntity<BaseResponse> transfferSalary(String month,Integer year){
		BaseResponse itemResponse=salaryTransactionService.transferSalaryFromMainAccountToEmployeeAccount(month, year);
		return new ResponseEntity<>(itemResponse,HttpStatus.CREATED);
	}
	

}

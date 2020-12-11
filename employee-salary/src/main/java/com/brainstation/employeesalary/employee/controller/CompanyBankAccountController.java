package com.brainstation.employeesalary.employee.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.brainstation.employeesalary.common.BaseResponse;
import com.brainstation.employeesalary.common.ItemResponse;
import com.brainstation.employeesalary.employee.model.request.CompanyBankAccountDepositRequest;
import com.brainstation.employeesalary.employee.service.CompanyBankAccountService;

@Controller
public class CompanyBankAccountController {
	
	
	@Autowired
	public CompanyBankAccountService companyBankAccountService;
	
	@GetMapping(value = "/company/bank-account/view")
	public ResponseEntity<ItemResponse> companyBankAccountView(){
		
		ItemResponse itemResponse=companyBankAccountService.companyBankAccountView();
		
		return new ResponseEntity<>(itemResponse,HttpStatus.OK);
		
	}
	
	
	@GetMapping(value = "/company/bank-account/balance/view")
	public ResponseEntity<ItemResponse> lowestSalaryView(){
		
		ItemResponse itemResponse=companyBankAccountService.companyBankBalanceView();
		
		return new ResponseEntity<>(itemResponse,HttpStatus.OK);
		
	}
	
	
	@PostMapping(value = "/company/bank-account/deposit")
	public ResponseEntity<BaseResponse> depositCompanyBankAccount(@RequestBody @Valid CompanyBankAccountDepositRequest request){
		
		BaseResponse itemResponse=companyBankAccountService.depositCompanyBankAccount(request);
		
		return new ResponseEntity<>(itemResponse,HttpStatus.CREATED);
		
	}

}

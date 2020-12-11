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
import com.brainstation.employeesalary.employee.model.request.LowestSalaryInputRequest;
import com.brainstation.employeesalary.employee.service.LowestSalaryService;

@Controller
public class LowestSalaryInputController {
	
	@Autowired
	public LowestSalaryService lowestSalaryService;
	
	@GetMapping(value = "/lowest/salary/view")
	public ResponseEntity<ItemResponse> lowestSalaryView(){
		
		ItemResponse itemResponse=lowestSalaryService.lowestSalaryView();
		
		return new ResponseEntity<>(itemResponse,HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/lowest/salary/save")
	public ResponseEntity<BaseResponse> lowestBasicSalarySave(@RequestBody @Valid LowestSalaryInputRequest request){
		
		BaseResponse itemResponse=lowestSalaryService.inputLowestBasicSalary(request);
		
		return new ResponseEntity<>(itemResponse,HttpStatus.CREATED);
		
	}

}

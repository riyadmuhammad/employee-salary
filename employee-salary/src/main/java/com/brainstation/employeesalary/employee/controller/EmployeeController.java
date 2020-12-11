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
import com.brainstation.employeesalary.employee.model.request.EmployeeInputRequest;
import com.brainstation.employeesalary.employee.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	public EmployeeService employeeService;
     
	@PostMapping(value = "/employee/save")
	public ResponseEntity<BaseResponse> saveEmployee(@RequestBody @Valid EmployeeInputRequest request){
		BaseResponse baseResponse=employeeService.saveEmployee(request);
		return new ResponseEntity<>(baseResponse,HttpStatus.CREATED);
	}
	
	
	@GetMapping(value = "/employee/list")
	public ResponseEntity<ItemResponse> employeeList(){
		ItemResponse itemResponse=employeeService.employeeList();
		return new ResponseEntity<>(itemResponse,HttpStatus.OK);
	}
	
}

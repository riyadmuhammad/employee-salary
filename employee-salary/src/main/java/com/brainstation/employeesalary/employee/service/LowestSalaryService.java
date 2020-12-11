package com.brainstation.employeesalary.employee.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brainstation.employeesalary.common.BaseResponse;
import com.brainstation.employeesalary.common.ItemResponse;
import com.brainstation.employeesalary.employee.model.entity.BasicSalaryLowestRange;
import com.brainstation.employeesalary.employee.model.request.LowestSalaryInputRequest;
import com.brainstation.employeesalary.employee.model.response.LowestSalaryViewResponse;
import com.brainstation.employeesalary.employee.repository.BasicSalaryLowestRangeRepository;

@Service
public class LowestSalaryService {
	
	
	@Autowired
	public BasicSalaryLowestRangeRepository basicSalaryLowestRangeRepository;
	
	
	public ItemResponse lowestSalaryView() {
		
		ItemResponse itemResponse=new ItemResponse();
		
		LowestSalaryViewResponse lowestSalaryViewResponse=new LowestSalaryViewResponse();
		
		BasicSalaryLowestRange salaryLowestRange=basicSalaryLowestRangeRepository.findOne(1l);
		
		if(salaryLowestRange==null) {
			BasicSalaryLowestRange basic=new BasicSalaryLowestRange();
			basic.setId(1l);
			basic.setLowestBasicSalary(0d);
			
			basicSalaryLowestRangeRepository.save(basic);
			
			lowestSalaryViewResponse.setId(1l);
			lowestSalaryViewResponse.setLowestBasicSalary(0d);
		}else {
			lowestSalaryViewResponse.setId(salaryLowestRange.getId());
			lowestSalaryViewResponse.setLowestBasicSalary(salaryLowestRange.getLowestBasicSalary());
		}
		
		itemResponse.setItem(lowestSalaryViewResponse);
		itemResponse.setMessage("OK");
		itemResponse.setMessageType(1);
		return itemResponse;
		
	}
	
	
	@Transactional
    public BaseResponse inputLowestBasicSalary(LowestSalaryInputRequest request) {
		
		BaseResponse itemResponse=new BaseResponse();

		BasicSalaryLowestRange salaryLowestRange=basicSalaryLowestRangeRepository.findOne(request.getId());
		salaryLowestRange.setLowestBasicSalary(request.getLowestBasicSalary());
		
		itemResponse.setMessage("Lowest Basic Salary Successfully Updated");
		itemResponse.setMessageType(1);
		return itemResponse;
		
	}

}

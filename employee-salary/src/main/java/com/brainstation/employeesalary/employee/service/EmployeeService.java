package com.brainstation.employeesalary.employee.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brainstation.employeesalary.common.BaseResponse;
import com.brainstation.employeesalary.common.ItemResponse;
import com.brainstation.employeesalary.employee.model.entity.BasicSalaryLowestRange;
import com.brainstation.employeesalary.employee.model.entity.Employee;
import com.brainstation.employeesalary.employee.model.entity.EmployeeBankAccount;
import com.brainstation.employeesalary.employee.model.pojo.SalaryGrade;
import com.brainstation.employeesalary.employee.model.pojo.SalaryGradeFactory;
import com.brainstation.employeesalary.employee.model.pojo.SalaryGradeFive;
import com.brainstation.employeesalary.employee.model.pojo.SalaryGradeFour;
import com.brainstation.employeesalary.employee.model.pojo.SalaryGradeOne;
import com.brainstation.employeesalary.employee.model.pojo.SalaryGradeSix;
import com.brainstation.employeesalary.employee.model.pojo.SalaryGradeThree;
import com.brainstation.employeesalary.employee.model.pojo.SalaryGradeTwo;
import com.brainstation.employeesalary.employee.model.request.EmployeeInputRequest;
import com.brainstation.employeesalary.employee.model.response.EmployeeView;
import com.brainstation.employeesalary.employee.repository.BasicSalaryLowestRangeRepository;
import com.brainstation.employeesalary.employee.repository.EmployeeBankAccountRepository;
import com.brainstation.employeesalary.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	
	@Autowired
	public EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeBankAccountRepository employeeBankAccountRepository;
	
	@Autowired
	public BasicSalaryLowestRangeRepository basicSalaryLowestRangeRepository;
	

	
	
	
	@Transactional
	public BaseResponse saveEmployee(EmployeeInputRequest request) {
		
		BaseResponse baseResponse=new BaseResponse();
		Long maxCustomEmployeeId=employeeRepository.findMaxCustomEmployeeId()+1;
		
		Employee employee=new Employee();
		employee.setAddress(request.getAddress());
		employee.setEmployeeName(request.getEmployeeName());
		employee.setEmployeeCustomId(String.valueOf(maxCustomEmployeeId));
		employee.setGradeId(request.getGradeId());
		employee.setMobile(request.getMobile());

		employee=employeeRepository.save(employee);
		
		EmployeeBankAccount employeeBankAccount=new EmployeeBankAccount();
		employeeBankAccount.setAccountName(request.getAccountName());
		employeeBankAccount.setAccountNumber(request.getAccountNumber());
		employeeBankAccount.setAccountType(request.getAccountType());
		employeeBankAccount.setBankName(request.getBankName());
		employeeBankAccount.setBranchName(request.getBranchName());
		employeeBankAccount.setCurrentBalance(request.getCurrentBalance());
		employeeBankAccount.setEmployee(employee);
		
		employeeBankAccountRepository.save(employeeBankAccount);
		
		baseResponse.setMessage("Employee Successfully Saved.");
		baseResponse.setMessageType(1);
		
		return baseResponse;
		
	}
	
	
	
   public ItemResponse employeeList() {
		
	   ItemResponse itemResponse=new ItemResponse();
	   BasicSalaryLowestRange salaryLowestRange=basicSalaryLowestRangeRepository.findOne(1l);
	   SalaryGradeFactory factory=new SalaryGradeFactory();
	   factory.setLowestBasicSalary(salaryLowestRange.getLowestBasicSalary());
	   
	   List<EmployeeView> views=new ArrayList<>();
	   
	   List<EmployeeBankAccount> bankAccounts=employeeBankAccountRepository.findAll();
	   
	   for(EmployeeBankAccount acc:bankAccounts) {
		   
		   EmployeeView view=new EmployeeView();
		   
		   view.setAccountName(acc.getAccountName());
		   view.setAccountNumber(acc.getAccountNumber());
		   view.setAccountType(acc.getAccountType());
		   view.setAddress(acc.getEmployee().getAddress());
		   view.setBankAccountId(acc.getBankAccountId());
		   view.setBankName(acc.getBankName());
		   view.setBranchName(acc.getBranchName());
		   view.setCurrentBalance(acc.getCurrentBalance());
		   view.setEmpId(acc.getEmployee().getEmpId());
		   view.setEmployeeCustomId(acc.getEmployee().getEmployeeCustomId());
		   view.setEmployeeName(acc.getEmployee().getEmployeeName());
		   view.setGradeId(acc.getEmployee().getGradeId());
		   view.setGradeName(gradeName(acc.getEmployee().getGradeId()));
		   view.setMobile(acc.getEmployee().getMobile());
		   
		   SalaryGrade salaryGrade=factory.findSalaryGrade(acc.getEmployee().getGradeId());
		   view.setBasic(salaryGrade.basic);
		   view.setHouseRent(salaryGrade.houseRent);
		   view.setMedical(salaryGrade.medicalAllowance);
		   view.setGross(salaryGrade.grossSalary);
		   
		   views.add(view);
		   
	   }
		
		
	    itemResponse.setItem(views);
		itemResponse.setMessage("OK");
		itemResponse.setMessageType(1);
		
		return itemResponse;
		
	}
   
   
  
   public String gradeName(Integer gradeId) {
	   
	   String gradeName;
		
		switch(gradeId) {
		
		  case 1:
			  gradeName="Grade One";
		    break;
		    
		  case 2:
			  gradeName="Grade Two";
		    break;
		    
		  case 3:
			  gradeName="Grade Three";
		    break;
		    
		  case 4:
			  gradeName="Grade Four";
		    break;
		    
		  case 5:
			  gradeName="Grade Five";
		    break;
		    
		  case 6:
			  gradeName="Grade Six";
		    break;   
		   
		  default:
			  gradeName="";
		    
		}
		
		return gradeName;
   }

}

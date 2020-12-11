package com.brainstation.employeesalary.employee.service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brainstation.employeesalary.common.BaseResponse;
import com.brainstation.employeesalary.employee.model.entity.BasicSalaryLowestRange;
import com.brainstation.employeesalary.employee.model.entity.CompanyBankAccount;
import com.brainstation.employeesalary.employee.model.entity.CompanyBankAccountTransaction;
import com.brainstation.employeesalary.employee.model.entity.EmployeeBankAccount;
import com.brainstation.employeesalary.employee.model.entity.EmployeeBankAccountTransaction;
import com.brainstation.employeesalary.employee.model.entity.SalaryTransaction;
import com.brainstation.employeesalary.employee.model.pojo.SalaryGrade;
import com.brainstation.employeesalary.employee.model.pojo.SalaryGradeFactory;
import com.brainstation.employeesalary.employee.repository.BasicSalaryLowestRangeRepository;
import com.brainstation.employeesalary.employee.repository.CompanyBankAccountRepository;
import com.brainstation.employeesalary.employee.repository.CompanyBankAccountTransactionRepository;
import com.brainstation.employeesalary.employee.repository.EmployeeBankAccountRepository;
import com.brainstation.employeesalary.employee.repository.EmployeeBankAccountTransactionRepository;
import com.brainstation.employeesalary.employee.repository.SalaryTransactionRepository;

@Service
public class SalaryTransactionService {
	
	
	@Autowired
	public EmployeeBankAccountRepository employeeBankAccountRepository;
	
	@Autowired
	public BasicSalaryLowestRangeRepository basicSalaryLowestRangeRepository;
	
	@Autowired
	public CompanyBankAccountRepository companyBankAccountRepository;
	
	@Autowired
	public SalaryTransactionRepository salaryTransactionRepository;
	
	@Autowired
	public EmployeeBankAccountTransactionRepository employeeBankAccountTransactionRepository;
	
	@Autowired
	public CompanyBankAccountTransactionRepository companyBankAccountTransactionRepository;
	
	
	@Transactional
	public BaseResponse transferSalaryFromMainAccountToEmployeeAccount(String month,Integer year) {
		
		BaseResponse baseResponse=new BaseResponse();
		BasicSalaryLowestRange salaryLowestRange=basicSalaryLowestRangeRepository.findOne(1l);
		SalaryGradeFactory factory=new SalaryGradeFactory();
		factory.setLowestBasicSalary(salaryLowestRange.getLowestBasicSalary());
		
		CompanyBankAccount companyBankAccount=companyBankAccountRepository.findOne(1l);
		   
		double totalEmployeeSalary=0;
		List<EmployeeBankAccount> bankAccounts=employeeBankAccountRepository.findAll();
		for(EmployeeBankAccount ac:bankAccounts) {
			SalaryGrade salaryGrade=factory.findSalaryGrade(ac.getEmployee().getGradeId());
			totalEmployeeSalary+=salaryGrade.grossSalary;
		}
		
		if(companyBankAccount.getCurrentBalance()<totalEmployeeSalary) {
			baseResponse.setMessage("Company Balance is not Sufficient.");
			baseResponse.setMessageType(0);
			return baseResponse;
		}
		
		
		List<EmployeeBankAccountTransaction> employeeBankAccountTransactions=new LinkedList<>();
		List<SalaryTransaction> salaryTransactions=new LinkedList<>();
		
		for(EmployeeBankAccount ac:bankAccounts) {
			
			SalaryGrade salaryGrade=factory.findSalaryGrade(ac.getEmployee().getGradeId());
			double gross=salaryGrade.grossSalary;
			double basic=salaryGrade.basic;
			double houserent=salaryGrade.houseRent;
			double medical=salaryGrade.medicalAllowance;
			
			EmployeeBankAccountTransaction bankAccountTransaction=new EmployeeBankAccountTransaction();
			bankAccountTransaction.setDeposit(gross);
			bankAccountTransaction.setEmployeeBankAccount(ac);
			bankAccountTransaction.setNote("Salary Deposit");
			bankAccountTransaction.setTrnDate(new Date());
			bankAccountTransaction.setWithdraw(0d);
			employeeBankAccountTransactions.add(bankAccountTransaction);
			
			
			SalaryTransaction salaryTransaction=new SalaryTransaction();
			salaryTransaction.setBasic(basic);
			salaryTransaction.setEmployeeBankAccount(ac);
			salaryTransaction.setGross(gross);
			salaryTransaction.setHouseRent(houserent);
			salaryTransaction.setMedical(medical);
			salaryTransaction.setMonth(month);
			salaryTransaction.setTrnDate(new Date());
			salaryTransaction.setYear(year);
			salaryTransactions.add(salaryTransaction);
			
			
			ac.setCurrentBalance(ac.getCurrentBalance()+gross);
			
		}
		
		
		CompanyBankAccountTransaction companyBankAccountTransaction=new CompanyBankAccountTransaction();
		companyBankAccountTransaction.setCompanyBankAccount(companyBankAccount);
		companyBankAccountTransaction.setDeposit(0d);
		companyBankAccountTransaction.setNote("Employee Salary Payment");
		companyBankAccountTransaction.setWithdraw(totalEmployeeSalary);
		
		companyBankAccountTransactionRepository.save(companyBankAccountTransaction);
		salaryTransactionRepository.save(salaryTransactions);
		employeeBankAccountTransactionRepository.save(employeeBankAccountTransactions);
		companyBankAccount.setCurrentBalance(companyBankAccount.getCurrentBalance()-totalEmployeeSalary);
		
		
		baseResponse.setMessage("Salay Transfer Successfully Done.");
		baseResponse.setMessageType(1);
		return baseResponse;
		
	}

}

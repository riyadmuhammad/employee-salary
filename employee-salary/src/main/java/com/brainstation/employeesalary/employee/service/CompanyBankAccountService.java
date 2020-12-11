package com.brainstation.employeesalary.employee.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brainstation.employeesalary.common.BaseResponse;
import com.brainstation.employeesalary.common.ItemResponse;
import com.brainstation.employeesalary.employee.model.entity.CompanyBankAccount;
import com.brainstation.employeesalary.employee.model.entity.CompanyBankAccountTransaction;
import com.brainstation.employeesalary.employee.model.request.CompanyBankAccountDepositRequest;
import com.brainstation.employeesalary.employee.model.response.CompanyBankAccountViewResponse;
import com.brainstation.employeesalary.employee.repository.CompanyBankAccountRepository;
import com.brainstation.employeesalary.employee.repository.CompanyBankAccountTransactionRepository;

@Service
public class CompanyBankAccountService {
	
	@Autowired
	public CompanyBankAccountRepository companyBankAccountRepository;
	
	@Autowired
	public CompanyBankAccountTransactionRepository companyBankAccountTransactionRepository;
	
	
	public ItemResponse companyBankAccountView() {
		
		ItemResponse itemResponse=new ItemResponse();
		
		CompanyBankAccountViewResponse response=new CompanyBankAccountViewResponse();
		
		CompanyBankAccount companyBankAccount=companyBankAccountRepository.findOne(1l);
		
		if(companyBankAccount==null) {
			companyBankAccount=new CompanyBankAccount();
			companyBankAccount.setAccountId(1l);
			companyBankAccount.setAccountName("Brain Station 23 LTD");
			companyBankAccount.setAccountType("Current");
			companyBankAccount.setBankName("Islami Bank Bangladesh LTD");
			companyBankAccount.setBranchName("Mohakhali");
			companyBankAccount.setCurrentBalance(0d);
			companyBankAccountRepository.save(companyBankAccount);
			

			response.setAccountId(1l);
			response.setAccountName("Brain Station 23 LTD");
			response.setAccountType("Current");
			response.setBankName("Islami Bank Bangladesh LTD");
			response.setBranchName("Mohakhali");
			response.setCurrentBalance(0d);
			
		}else {
			
			response.setAccountId(companyBankAccount.getAccountId());
			response.setAccountName(companyBankAccount.getAccountName());
			response.setAccountType(companyBankAccount.getAccountType());
			response.setBankName(companyBankAccount.getBankName());
			response.setBranchName(companyBankAccount.getBranchName());
			response.setCurrentBalance(companyBankAccount.getCurrentBalance());
			
		}
		
		itemResponse.setItem(response);
		itemResponse.setMessage("OK");
		itemResponse.setMessageType(1);
		return itemResponse;
	}
	
	
	
   public ItemResponse companyBankBalanceView() {
		
		ItemResponse itemResponse=new ItemResponse();
		
		CompanyBankAccountViewResponse response=new CompanyBankAccountViewResponse();
		
		CompanyBankAccount companyBankAccount=companyBankAccountRepository.findOne(1l);
		
		List<CompanyBankAccountTransaction> transactions=companyBankAccountTransactionRepository.findAll();
		
		double totalwithdraw=0;
		double totaldeposit=0;
		
		for(CompanyBankAccountTransaction trn:transactions) {
			totalwithdraw+=trn.getWithdraw();
			totaldeposit+=trn.getDeposit();
		}
		
	        response.setAccountId(companyBankAccount.getAccountId());
			response.setAccountName(companyBankAccount.getAccountName());
			response.setAccountType(companyBankAccount.getAccountType());
			response.setBankName(companyBankAccount.getBankName());
			response.setBranchName(companyBankAccount.getBranchName());
			response.setCurrentBalance(companyBankAccount.getCurrentBalance());
			
			response.setTotalDeposit(totaldeposit);
			response.setTotalWithdraw(totalwithdraw);
			
	
		
		itemResponse.setItem(response);
		itemResponse.setMessage("OK");
		itemResponse.setMessageType(1);
		return itemResponse;
	}
	
	
	@Transactional
    public BaseResponse depositCompanyBankAccount(CompanyBankAccountDepositRequest request) {
		
	    BaseResponse itemResponse=new BaseResponse();
		
		CompanyBankAccount companyBankAccount=companyBankAccountRepository.findOne(request.getAccountId());
		companyBankAccount.setCurrentBalance(companyBankAccount.getCurrentBalance()+request.getDeposit());
		
		
		CompanyBankAccountTransaction companyBankAccountTransaction=new CompanyBankAccountTransaction();
		
		companyBankAccountTransaction.setCompanyBankAccount(companyBankAccount);
		companyBankAccountTransaction.setDeposit(request.getDeposit());
		companyBankAccountTransaction.setNote("Amount Deposit");
		companyBankAccountTransaction.setWithdraw(0d);
		
		companyBankAccountTransactionRepository.save(companyBankAccountTransaction);

		itemResponse.setMessage("Deposit Successfully Done.");
		itemResponse.setMessageType(1);
		return itemResponse;
	}
	
	

}

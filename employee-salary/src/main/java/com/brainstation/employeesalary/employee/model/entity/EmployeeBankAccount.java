package com.brainstation.employeesalary.employee.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee_bank_account")
public class EmployeeBankAccount implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "bank_account_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bankAccountId;
	
	
	@OneToOne
	@JoinColumn(name = "emp_id",unique = true,nullable = false)
	private Employee employee;
	
	@Column(name = "account_type")
	private String accountType;
	
	
	@Column(name = "account_name")
	private String accountName;
	
	
	@Column(name = "account_number")
	private String accountNumber;
	
	
	@Column(name = "current_balance")
	private Double currentBalance;
	
	
	@Column(name = "bank_name")
	private String bankName;
	
	
	@Column(name = "branch_name")
	private String branchName;


	public Long getBankAccountId() {
		return bankAccountId;
	}


	public void setBankAccountId(Long bankAccountId) {
		this.bankAccountId = bankAccountId;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public String getAccountName() {
		return accountName;
	}


	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}


	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public Double getCurrentBalance() {
		return currentBalance;
	}


	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}


	public String getBankName() {
		return bankName;
	}


	public void setBankName(String bankName) {
		this.bankName = bankName;
	}


	public String getBranchName() {
		return branchName;
	}


	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
	
	
	
	
}

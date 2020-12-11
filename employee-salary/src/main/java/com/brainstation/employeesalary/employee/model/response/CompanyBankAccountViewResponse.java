package com.brainstation.employeesalary.employee.model.response;

public class CompanyBankAccountViewResponse {


	private Long accountId;
	
	private String bankName;
	
	private String branchName;
	
	private String accountType;
	
	private String accountName;
	
	private Double currentBalance;
	
	private Double totalWithdraw;
	
	private Double totalDeposit;

	
	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
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

	public Double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public Double getTotalWithdraw() {
		return totalWithdraw;
	}

	public void setTotalWithdraw(Double totalWithdraw) {
		this.totalWithdraw = totalWithdraw;
	}

	public Double getTotalDeposit() {
		return totalDeposit;
	}

	public void setTotalDeposit(Double totalDeposit) {
		this.totalDeposit = totalDeposit;
	}
	
	
	
}

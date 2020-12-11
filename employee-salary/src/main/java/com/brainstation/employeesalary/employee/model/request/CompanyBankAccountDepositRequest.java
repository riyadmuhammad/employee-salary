package com.brainstation.employeesalary.employee.model.request;

public class CompanyBankAccountDepositRequest {
	
	private Long accountId;
	
	private Double deposit;

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Double getDeposit() {
		return deposit;
	}

	public void setDeposit(Double deposit) {
		this.deposit = deposit;
	}
	
	

}

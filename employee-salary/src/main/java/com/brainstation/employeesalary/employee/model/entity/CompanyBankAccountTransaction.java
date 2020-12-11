package com.brainstation.employeesalary.employee.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "company_bank_account_transaction")
public class CompanyBankAccountTransaction implements Serializable{
	
	private static final long serialVersionUID = 345019938235935777L;

	@Id
	@Column(name = "trn_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long trnId;
	
	@ManyToOne
	@JoinColumn(name = "account_id",nullable = false)
	private CompanyBankAccount companyBankAccount;
	
	@Column(name = "deposit")
	private Double deposit;
	
	@Column(name = "withdraw")
	private Double withdraw;
	
	@Column(name = "note")
	private String note;

	public Long getTrnId() {
		return trnId;
	}

	public void setTrnId(Long trnId) {
		this.trnId = trnId;
	}

	public CompanyBankAccount getCompanyBankAccount() {
		return companyBankAccount;
	}

	public void setCompanyBankAccount(CompanyBankAccount companyBankAccount) {
		this.companyBankAccount = companyBankAccount;
	}

	public Double getDeposit() {
		return deposit;
	}

	public void setDeposit(Double deposit) {
		this.deposit = deposit;
	}

	public Double getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(Double withdraw) {
		this.withdraw = withdraw;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	
	
	
}

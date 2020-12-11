package com.brainstation.employeesalary.employee.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "employee_bank_account_transaction")
public class EmployeeBankAccountTransaction implements Serializable{
	
	
	private static final long serialVersionUID = 4118042570449557633L;

	@Id
	@Column(name = "trn_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long trnId;
	
	@ManyToOne
	@JoinColumn(name = "bank_account_id",nullable = false)
	private EmployeeBankAccount employeeBankAccount;
	
	@Column(name = "deposit")
	private Double deposit;
	
	@Column(name = "withdraw")
	private Double withdraw;
	
	@Column(name = "note")
	private String note;
	
	@Column(name = "trn_date")
	@Temporal(TemporalType.DATE)
	private Date trnDate;

	public Long getTrnId() {
		return trnId;
	}

	public void setTrnId(Long trnId) {
		this.trnId = trnId;
	}

	public EmployeeBankAccount getEmployeeBankAccount() {
		return employeeBankAccount;
	}

	public void setEmployeeBankAccount(EmployeeBankAccount employeeBankAccount) {
		this.employeeBankAccount = employeeBankAccount;
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

	public Date getTrnDate() {
		return trnDate;
	}

	public void setTrnDate(Date trnDate) {
		this.trnDate = trnDate;
	}
	
	

}

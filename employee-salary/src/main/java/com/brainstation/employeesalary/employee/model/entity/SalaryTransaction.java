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
@Table(name = "salary_transaction")
public class SalaryTransaction implements Serializable{
	
	
	private static final long serialVersionUID = -5311947470033738204L;


	@Id
	@Column(name = "trn_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long trnId;
	
	
	@ManyToOne
	@JoinColumn(name = "bank_account_id")
	private EmployeeBankAccount employeeBankAccount;
	
	
	@Column(name = "month")
	private String month;
	
	@Column(name = "basic")
	private Double basic;
	
	@Column(name = "house_rent")
	private Double houseRent;
	
	@Column(name = "medical")
	private Double medical;
	
	@Column(name = "gross")
	private Double gross;
	
	@Column(name = "year")
	private Integer year;
	
	@Column(name = "trnDate")
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

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Double getBasic() {
		return basic;
	}

	public void setBasic(Double basic) {
		this.basic = basic;
	}

	public Double getHouseRent() {
		return houseRent;
	}

	public void setHouseRent(Double houseRent) {
		this.houseRent = houseRent;
	}

	public Double getMedical() {
		return medical;
	}

	public void setMedical(Double medical) {
		this.medical = medical;
	}

	public Double getGross() {
		return gross;
	}

	public void setGross(Double gross) {
		this.gross = gross;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Date getTrnDate() {
		return trnDate;
	}

	public void setTrnDate(Date trnDate) {
		this.trnDate = trnDate;
	}

	
}

package com.brainstation.employeesalary.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brainstation.employeesalary.employee.model.entity.CompanyBankAccountTransaction;

public interface CompanyBankAccountTransactionRepository extends JpaRepository<CompanyBankAccountTransaction, Long>{

}

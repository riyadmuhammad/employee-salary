package com.brainstation.employeesalary.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brainstation.employeesalary.employee.model.entity.CompanyBankAccount;

public interface CompanyBankAccountRepository extends JpaRepository<CompanyBankAccount, Long>{

}

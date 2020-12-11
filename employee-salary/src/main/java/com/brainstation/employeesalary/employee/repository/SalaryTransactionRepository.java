package com.brainstation.employeesalary.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brainstation.employeesalary.employee.model.entity.SalaryTransaction;

public interface SalaryTransactionRepository extends JpaRepository<SalaryTransaction, Long>{

}

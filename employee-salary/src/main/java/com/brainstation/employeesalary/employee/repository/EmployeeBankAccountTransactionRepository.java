package com.brainstation.employeesalary.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brainstation.employeesalary.employee.model.entity.EmployeeBankAccountTransaction;

public interface EmployeeBankAccountTransactionRepository extends JpaRepository<EmployeeBankAccountTransaction, Long>{

}

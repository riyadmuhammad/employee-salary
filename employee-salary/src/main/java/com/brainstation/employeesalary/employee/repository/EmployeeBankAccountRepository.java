package com.brainstation.employeesalary.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brainstation.employeesalary.employee.model.entity.EmployeeBankAccount;

public interface EmployeeBankAccountRepository extends JpaRepository<EmployeeBankAccount, Long>{

}

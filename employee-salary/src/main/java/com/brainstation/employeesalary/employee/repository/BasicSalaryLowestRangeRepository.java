package com.brainstation.employeesalary.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brainstation.employeesalary.employee.model.entity.BasicSalaryLowestRange;

public interface BasicSalaryLowestRangeRepository extends JpaRepository<BasicSalaryLowestRange, Long>{

}

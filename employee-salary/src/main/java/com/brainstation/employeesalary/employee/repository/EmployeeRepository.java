package com.brainstation.employeesalary.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.brainstation.employeesalary.employee.model.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	@Query(value = "select (case when max(employee_custom_id) is not null then max(employee_custom_id) else 8000 end) from employee  where employee_custom_id REGEXP '^[0-9]' ",nativeQuery=true)
    public Long findMaxCustomEmployeeId();

}

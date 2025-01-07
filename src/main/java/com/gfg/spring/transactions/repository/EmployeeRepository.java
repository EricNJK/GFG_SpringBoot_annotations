package com.gfg.spring.transactions.repository;

import com.gfg.spring.transactions.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}

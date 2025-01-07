package com.gfg.spring.transactions.controller;

import com.gfg.spring.transactions.model.Employee;
import com.gfg.spring.transactions.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // This endpoint saves a valid address and employee.
    @PostMapping("/add")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) throws Exception {
        Employee savedEmployee = employeeService.addEmployee(employee);

        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // This endpoint tries to save an invalid address (null), causing an error.
    @PostMapping("/addWithError")
    public ResponseEntity<Employee> saveEmployeeWithInvalidAddress(@RequestBody Employee employee) throws Exception {
        Employee savedEmployee = employeeService.addEmployeeIntentionalException(employee);

        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
}

package com.gfg.spring.transactions.service;

import com.gfg.spring.transactions.model.Address;
import com.gfg.spring.transactions.model.Employee;
import com.gfg.spring.transactions.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final AddressService addressService;

    public EmployeeService(EmployeeRepository employeeRepository, AddressService addressService) {
        this.employeeRepository = employeeRepository;
        this.addressService = addressService;
    }

    // from org.springframework.transaction..., not jakarta.transaction
    @Transactional
    public Employee addEmployee(Employee employee) {
        Employee saved = employeeRepository.save(employee);

        Address addressWithoutId = new Address();
        // using the updated employee
        addressWithoutId.setEmployee(saved);
        // todo : get correct value from arguments
        addressWithoutId.setAddress("Home - " + saved.getName());

        Address unused = addressService.addAddress(addressWithoutId);
        return saved;
    }

    @Transactional
    public Employee addEmployeeIntentionalException(Employee employee) {
        Employee saved = employeeRepository.save(employee);

        // cause an error - should roll back the save(employee) operation
        Address unused = addressService.addAddress(null);
        return saved;
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}

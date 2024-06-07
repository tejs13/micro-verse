package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Employee;
import com.example.demo.repositories.EmployeeRepository;


@Service
public class EmployeeService {
	
	
	@Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveNewEmp(Employee emp) {
        return employeeRepository.save(emp);
    }

}

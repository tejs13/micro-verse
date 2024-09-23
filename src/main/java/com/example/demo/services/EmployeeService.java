package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.models.Employee;


public interface EmployeeService {
	
	public Employee saveNewEmp(Employee emp);
	
	public void deleteEmp(Long id);
	
	public Employee updateEmployee(Long id, EmployeeDTO empDTO);
	
	public Employee findEmployeeByName(String fname);
	
	public Employee getEmployeeById(Long id);

}

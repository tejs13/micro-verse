package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.models.Employee;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.exceptions.*;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
	@Autowired
    private EmployeeRepository employeeRepository;

	@Override
	public Employee saveNewEmp(Employee emp) {
        return employeeRepository.save(emp);
    }
	
	@Override
	public void deleteEmp(Long id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
		
	}
	
	
	@Override
	public Employee updateEmployee(Long id, EmployeeDTO empDTO) {
		Employee empObj = employeeRepository.findById(id).get();
		
		 // Update the entity with DTO values (partial update)
        if (empDTO.getFirstName() != null) {
        	empObj.setFirstName(empDTO.getFirstName());
        }
        if (empDTO.getLastName() != null) {
        	empObj.setLastName(empDTO.getLastName());
        }
        if (empDTO.getEmailId() != null) {
        	empObj.setEmailId(empDTO.getEmailId());
        }
        if (empDTO.getPhone() != null) {
        	empObj.setPhone(empDTO.getPhone());
        }
        
		
		return employeeRepository.save(empObj);
	}
	
	@Override
	public Employee findEmployeeByName(String fname) {
		return employeeRepository.findByfirstNameIgnoreCase(fname);
	}
	 
	@Override
	public Employee getEmployeeById(Long id) throws ResourceNotFoundException {
		// Optinal is introduces in JAVA 8 to check and handle the NULL values more efficiently
		Optional<Employee> empPresent = employeeRepository.findById(id);
		if(! empPresent.isPresent()) {
			throw new ResourceNotFoundException("Given ID does not exists !!");
		}
		else {
			return empPresent.get();
		}
	}

}

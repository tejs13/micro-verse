/**
 * 
 */
package com.example.demo.controllers;

/**
 * 
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.Employee;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.services.EmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeService employeeService;

	// get all employees
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return new ResponseEntity<List<Employee>>(employeeRepository.findAll(), HttpStatus.OK);
		
	}
	
	
	@PostMapping("/add-employee")
	public ResponseEntity<Employee> addNewEmployee(@RequestBody EmployeeDTO data) {
		System.out.print(data);
		//convert DTO to entity
		Employee e = new Employee();
		e.setEmailId(data.getEmailId());
		e.setFirstName(data.getFirstName());
		e.setLastName(data.getLastName());
		e.setPhone(data.getPhone());
		
		Employee emp = employeeService.saveNewEmp(e);
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
		
	}
	
	

//	 get employee by id rest api
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(employee);
	}
}

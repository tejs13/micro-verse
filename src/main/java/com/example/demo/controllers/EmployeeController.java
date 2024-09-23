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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
import com.example.demo.services.EmployeeServiceImpl;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired // inversion of control, we don't create object with NEW keyword
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@Value("${welcome.message}")
	private String welcomeMessage;
	
	// HomePage welcome
	@GetMapping("/")
	public String homePage() {
		return welcomeMessage;
	}

	// get all employees
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return new ResponseEntity<List<Employee>>(employeeRepository.findAll(), HttpStatus.OK);

	}
	
	// @valid is for validating the request JSON Data.
	@PostMapping("/add-employee")
	public ResponseEntity<Employee> addNewEmployee(@Valid @RequestBody EmployeeDTO data) { // @RequestBody convertts the
																					// request body to DTO
		// without this , need to use objectmapper and parse the request body to Json

		System.out.print(data);
		// convert DTO to entity
		Employee e = new Employee();
		e.setEmailId(data.getEmailId());
		e.setFirstName(data.getFirstName()); 
		e.setLastName(data.getLastName());
		e.setPhone(data.getPhone());

		Employee emp = employeeService.saveNewEmp(e);
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);

	}

	// get employee by id rest api
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) throws ResourceNotFoundException {
//		Employee employee = employeeRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		  
		return ResponseEntity.ok(employeeService.getEmployeeById(id));
	}

	// Delete Employee by id
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Long id) {

		employeeService.deleteEmp(id);
		return new ResponseEntity<String>("Delete d Successfully", HttpStatus.OK);

	}

	// Update employee by id

	@PutMapping("/employees/{id}")
	public ResponseEntity<Object> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeDTO data) {

		try {
			return new ResponseEntity<>(employeeService.updateEmployee(id, data), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("employee/name/{name}")
	public ResponseEntity<Object> getMethodName(@PathVariable("name") String name) {
		try {
			System.out.println(employeeService.findEmployeeByName(name));
			return new ResponseEntity<>(employeeService.findEmployeeByName(name), HttpStatus.OK);	
		}
		catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}

package com.example.demo.models;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "EMPLOYEES")

public class Employee {

	@Id // PK for the table
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "first_name")
	@NotBlank(message = "First Name should not be blank")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email_address")
	@Email // spring starter validation
	private String emailId;

	@Column(name = "phone")
	@Length(max = 10, min = 10) // spring started validation
	private String phone;

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", phone=" + phone + "]";
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Employee() {

	}

	public Employee(long id, String firstName, String lastName, String emailId, String phone) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.phone = phone;
	}

	// Builder Pattern
	public Employee(EmployeeBuilder employeeBuilder) {
		this.firstName = employeeBuilder.firstName;
		this.lastName = employeeBuilder.lastName;
		this.emailId = employeeBuilder.emailId;
		this.phone = employeeBuilder.phone;
	}

	public static class EmployeeBuilder {
		
//		private long id;
		private String firstName;
		private String lastName;
		private String emailId;
		private String phone;

		public EmployeeBuilder() {
		}

		public EmployeeBuilder setfirstName(String fname) {
			this.firstName = fname;
			return this;
		}
		public EmployeeBuilder setlastName(String lname) {
			this.lastName = lname;
			return this;
		}
		public EmployeeBuilder setemailId(String email) {
			this.emailId = email;
			return this;
		}
		public EmployeeBuilder setphone(String ph) {
			this.phone = ph;
			return this;
		}
		
		public Employee build() {
			return new Employee(this);
		}

	}

	// Use Object validation, for ex Not Null, Required, to parse the json data from
	// request,
//	- use spring-boot-starter-validation

	// Reduce the boilerplate code i.e gettersetter, constrctors, tostring methods,
	// this will be the same for all the entities
	// we use the Lombock library for that
	
	
	// BUILDER PATTERN
//	- to define with calrity and less code for class having many properties
//	 - eliminate the hassle to create constrcutors for every combinations

}

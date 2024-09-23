package com.example.demo.repositories;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.demo.models.Employee;

@DataJpaTest // for temporary databse funtionality
class EmployeeRepositoryTest {
	
	@Autowired
	private EmployeeRepository employeeRepository;


	private TestEntityManager entityManager;
	
	@BeforeEach
	void setUp() throws Exception {

		Employee emp = new Employee.EmployeeBuilder().setfirstName("K").setlastName("Patel").setemailId("Nik@gmail.com")
				.setphone("12434").build();
		
		entityManager.persist(emp);
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	public void whenGetById_ReturnEmployee() {
		
		Employee emp = employeeRepository.findById(1L).get();
		
		assertEquals(emp.getFirstName(), "K");

	}

}

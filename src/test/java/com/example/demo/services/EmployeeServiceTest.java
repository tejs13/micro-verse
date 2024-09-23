/**
 * 
 */
package com.example.demo.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.models.Employee;
import com.example.demo.repositories.EmployeeRepository;

/**
 * 
 */

@SpringBootTest // to define test as  Springboot test
class EmployeeServiceTest {
	
	@Autowired
	private EmployeeService employeeService;
	
	@MockBean // Need to mock this bean, when is tis called
	private EmployeeRepository employeeRepository;

	
	@BeforeEach  // called before each test case method is executed
//	@BeforeAll // Called just Once, before any test case method is executed
	void setUp() throws Exception {
		
		Employee emp = new Employee.EmployeeBuilder()
				.setfirstName("Nik")
				.setlastName("Patel")
				.setemailId("Nik@gmail.com")
				.setphone("1234").build();
		
		// Binds to this method of reposiorty layer, mocking Repository layer 
		Mockito.when(employeeRepository.findByfirstNameIgnoreCase("Nik")).thenReturn(emp);
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	@DisplayName("Get by Employee Name")
	@Disabled // disable the testcase
	public void whenValidEmpName_ValidEmpFound() {
		
		// UNite test to test service layer, WITHOUT Mock
		
		String empName = "Tejas";
		
		Employee emp = employeeService.findEmployeeByName(empName);
		
		assertEquals(empName, emp.getFirstName());
		
	}

}



// Unitsting is basically, testing individual units separately,
//   i.e service layer, controller layer, reposiotry layer, when we say separately, 
// the depedency layer is mocked by mockit up




//- To test the Repository Layer, we need to have the temporary Database, 
//  - like data deleted after test completed - @DataJpaTest  - use for temporary data persistance





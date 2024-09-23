package com.example.demo.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.models.Employee;
import com.example.demo.services.EmployeeService;


//- Controller Layer Test
@WebMvcTest  // specifically for testing URLs, i.e controller layer test
class EmployeeControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private EmployeeService empployeeService;
	
	
	
	private Employee emp;

	@BeforeEach
	void setUp() throws Exception {
		
		 emp = new Employee.EmployeeBuilder().setfirstName("K").setlastName("Patel").setemailId("Nik@gmail.com")
				.setphone("12434").build();
		
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	@Disabled
	public void saveEmployee() {
		
		Employee inputEmp = new Employee.EmployeeBuilder().setfirstName("K").setlastName("Patel").setemailId("Nik@gmail.com")
				.setphone("12434").build();
		
		Mockito.when(empployeeService.saveNewEmp(inputEmp))
		.thenReturn(emp);
		
		try {
			mockMvc.perform(MockMvcRequestBuilders.post("/add-employee")
					.contentType(MediaType.APPLICATION_JSON)
					.content("{\n"
							+ "    \"firstName\": \"Test\",\n"
							+ "	\"lastName\": \"Patel\",\n"
							+ "	\"emailId\": \"tejas999@gmail.com\",\n"
							+ "	\"phone\": \"7683443777\"\n"
							+ "	\n"
							+ "}"))
			.andExpect(MockMvcResultMatchers.status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

/**
 * 
 */
package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Employee;

/**
 * 
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {  // pss the entity and PK type
	
	
	// custom method that is not implenented in reposiotyr
	// find by name, maintain the naming convention to find the eneitites by name
	// findBy<field to find>, JPA repositoy handled the logic 
	
	
	// varoous IN Built methods available, check JPA documentation
	public Employee findByfirstName(String fname);
	
	public Employee findByfirstNameIgnoreCase(String fname);
	
	
	//if complex query, use @query annoaiton
//		2 options - 
//			1. JPQL 
//			2. SQL query

}

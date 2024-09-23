package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})//,  scanBasePackages = {"com.example.demo.repositories", "com.example.demo.controllers"})

//@EntityScan(basePackages = {"com.example.demo.models"})
//@EnableTransactionManagement

@SpringBootApplication // key for springboot applications wraps, @sprinconfigutation, @enableautocongis, @componentscan
@EnableJpaRepositories(basePackages = {"com.example.demo.repositories"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}



// Spring Boot Notes:

//- starters in xml, groups all the depenecencies os that No need to add manually one by one like in sprin
//for ex: spring mvc, spring core, spring context, spring orm, hibernate-jpa, database etc etc
// Spring starter-web will add those automatically

//- in case of web in spring: need to add <servlet> in web.xml, dispatcherservlet,
  // - Springboot handles with @enableautoconfigs

// @componenetscan- scans all the componenets and add to spring container during start

// @RestController - it differ from simple controller, as it always returns @resonsebody,
// used in REST APIs development


// - Use application.properties files to manipulate spring's autoconfiguration
//  - FOr example, we change the port 


// Command to run form terminal: mvn spring-boot:run


// BUILD  and run the sprinboot application

//- command  mvn clean install -Dmaven.test.skip=true
// run the application : java --jar <jar file> --spring.pofiles.active=prod













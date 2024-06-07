package com.example.demo.config;

import org.hibernate.boot.jaxb.internal.stax.LocalSchemaLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

//@Configuration
public class AppConfig {
	
	@Bean(name="entityManagerFactory")
	public LocalSchemaLocator sessionFactory() {
	    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

	    return sessionFactory();
	} 

}

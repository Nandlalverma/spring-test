package com.employee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.employee.Dao.EmployeeDao;

@Component
public class MyConfig {

	@Bean
	public EmployeeDao empDto() {
		return new EmployeeDao();
	}
	
}

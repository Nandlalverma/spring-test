package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService{

	@Autowired
	 private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee emp) {
	return	employeeRepository.save(emp);
	}

	@Override
	public List<Employee> getAllEmployee() {
	return	employeeRepository.findAll();
	}
	
}

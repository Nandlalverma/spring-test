package com.employee.service;

import java.util.List;

import com.employee.entity.Employee;

public interface EmployeeService {

	public Employee addEmployee(Employee emp);
	public List<Employee> getAllEmployee();
}

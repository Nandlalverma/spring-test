package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.Dao.EmployeeDao;
import com.employee.entity.Employee;
import com.employee.entity.jpaEntity;
import com.employee.service.EmployeeService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/emp")
public class EmpController {

	@Autowired
	private EmployeeService employeeService;
	//@Autowired
	//private jpaEntity entity;
	
	@Autowired
	private EmployeeDao empDto;
	@PostMapping
	public ResponseEntity<Employee> getEmployee(@RequestBody Employee employee){
		Employee employee2 = employeeService.addEmployee(employee);
		return new ResponseEntity<Employee>(employee2,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmp(){
		List<Employee> allEmployee = employeeService.getAllEmployee();
		return new ResponseEntity<List<Employee>>(allEmployee,HttpStatus.OK);
	}
//   this is the jpa query test
	
	@PostMapping("/create")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee){
		EmployeeDao dto=new EmployeeDao();
		dto.createEmployee(employee);
		return  new ResponseEntity<String>("Successfully !",HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id){
		EmployeeDao dto=new EmployeeDao();
		Employee byId = dto.getEmployeeById(id);
		return new ResponseEntity<Employee>(byId,HttpStatus.OK);
	}
	
}

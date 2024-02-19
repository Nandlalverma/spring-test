package com.employee.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EmployeeDao {
   
	@PersistenceContext
	private EntityManager entityManager;
	public EmployeeDao(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	

	public EmployeeDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public void createEmployee(Employee employee) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(employee);
		transaction.commit();
	}
	
	public  List<Employee> getAll(){
		
	}
	
    public Employee getEmployeeById(Integer id) {
    	return entityManager.find(Employee.class, id);
    	 
    }
    public void updateEmployee(Employee emp) {
    	EntityTransaction transaction = entityManager.getTransaction();
    	transaction.begin();
    	Employee merge = entityManager.merge(emp);
    	transaction.commit();
    }
    public void deleteEmpById(Integer id) {
    	EntityTransaction transaction = entityManager.getTransaction();
    	transaction.begin();
    	Employee employee = entityManager.find(Employee.class, id);
    	entityManager.remove(employee);
    	transaction.commit();
    }
    
    

    
	
	
}

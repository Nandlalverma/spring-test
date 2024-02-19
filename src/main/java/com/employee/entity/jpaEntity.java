package com.employee.entity;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class jpaEntity {
    
	private EntityManager entityManager;
	public jpaEntity(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	
	
	public List<Employee> getAllEmployee(){
		String sql="select e from Employee where e.empName= :val";
		Query query = entityManager.createQuery(sql);
		query.setParameter("val", "mohan");
	    return 	query.getResultList();
	}
	
	public List<Employee> getByData(){
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> query = criteriaBuilder.createQuery(Employee.class);
		Root<Employee> from = query.from(Employee.class);
		query.select(from).where(criteriaBuilder.equal(from.get("empName"), query));
		return entityManager.createQuery(query).getResultList();
	}
	
	
}

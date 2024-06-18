package com.ibm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.entity.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, Integer> {
	
}

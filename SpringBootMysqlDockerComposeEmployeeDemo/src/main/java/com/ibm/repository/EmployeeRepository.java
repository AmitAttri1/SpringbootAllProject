package com.ibm.repository;

import org.springframework.data.repository.CrudRepository;

import com.ibm.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}

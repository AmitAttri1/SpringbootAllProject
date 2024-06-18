package com.bhartIT.repository;

import org.springframework.data.repository.CrudRepository;

import com.bhartIT.entity.Employee;

public interface EmployeeRepostory extends CrudRepository<Employee, Integer>{

}

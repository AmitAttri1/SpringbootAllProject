package com.bhartIT.service;

import java.util.List;

import com.bhartIT.dto.EmployeeDto;
import com.bhartIT.entity.Employee;
import com.bhartIT.exception.NewSbiException;

public interface EmployeeService {
	
	public EmployeeDto getData(Integer employeeId) throws NewSbiException;
	public List<EmployeeDto> getAllData() throws NewSbiException;
	public Integer addEmployee(EmployeeDto employee)throws NewSbiException;
	public void deleteData(Integer employeeId) throws NewSbiException;
	public Employee updateEmployee(Integer employeeId, Employee updatedEmployee);
	
	
	

}

package com.ibm.service;

import java.util.List;

import com.ibm.NewSbiException.NewSbiException;
import com.ibm.dto.EmployeeDTO;

public interface EmployeeService {
	
	public EmployeeDTO getData(Integer employeeId) throws NewSbiException;
	public List<EmployeeDTO> getAllEmployee() throws NewSbiException;

}

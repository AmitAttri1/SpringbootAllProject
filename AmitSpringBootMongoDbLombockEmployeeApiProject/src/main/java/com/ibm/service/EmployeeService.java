package com.ibm.service;

import java.util.List;

import com.ibm.dto.EmployeeDTO;
import com.ibm.exception.InfyBankException;

public interface EmployeeService {
	
	public Integer addEmployee(EmployeeDTO employeeDTO) throws InfyBankException;	
	public EmployeeDTO getEmployee(Integer id) throws InfyBankException;
	public List<EmployeeDTO> getAllEmployees() throws InfyBankException;
	public void deleteEmployee(Integer id)throws InfyBankException;
	public void updateEmployee(Integer id, String name,String role)throws InfyBankException;
	
}

package com.ibm.service;

import java.util.List;

import com.ibm.dto.EmployeeDTO;
import com.ibm.exception.SBIException;


public interface EmployeeService {
	
	public EmployeeDTO getEmployee(Integer employeeId) throws SBIException;
	public List<EmployeeDTO> getAllEmployee() throws SBIException;
	public Integer addEmployee(EmployeeDTO employeeDTO) throws SBIException;
	public void updateEmployee(Integer employeeId, String employeename) throws SBIException;

}

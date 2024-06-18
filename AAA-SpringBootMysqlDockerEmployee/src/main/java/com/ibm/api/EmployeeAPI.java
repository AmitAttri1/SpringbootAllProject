package com.ibm.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.NewSbiException.NewSbiException;
import com.ibm.dto.EmployeeDTO;
import com.ibm.service.EmployeeService;

@RestController
@RequestMapping(value = "/sbibank")
//http://localhost:8085/sbibank/employee/1
public class EmployeeAPI {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(value = "employee/{employeeId}")
	public ResponseEntity<EmployeeDTO> getData(@ PathVariable Integer employeeId) throws NewSbiException
	{
		EmployeeDTO employeedto = employeeService.getData(employeeId);
		return new ResponseEntity<>(employeedto,HttpStatus.OK);
		
	}
	
	@GetMapping(value = "employee")
	public ResponseEntity<List<EmployeeDTO>> getAllData() throws NewSbiException
	{
		List<EmployeeDTO> allEmployee = employeeService.getAllEmployee();
		
		return new ResponseEntity<>(allEmployee,HttpStatus.OK);
		
	}
	

}

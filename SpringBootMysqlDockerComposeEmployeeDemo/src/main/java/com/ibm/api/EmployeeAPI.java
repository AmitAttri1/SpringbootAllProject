package com.ibm.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.dto.EmployeeDTO;
import com.ibm.exception.SBIException;
import com.ibm.service.EmployeeService;

@RestController
@RequestMapping(value = "/sbibank")
public class EmployeeAPI {

	@Autowired
	private EmployeeService employeeService; 

	@Autowired
	private Environment environment;
	
	@GetMapping(value = "/message")
	public ResponseEntity<String> getMessage() {
		 String strMessage = "Welcome to Docker Integration";
		return new ResponseEntity<>(strMessage,HttpStatus.OK);
	}

	@GetMapping(value = "/employee/{employeeId}")
	public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Integer employeeId) throws SBIException{
		EmployeeDTO employeeDTO = employeeService.getEmployee(employeeId);
		return new ResponseEntity<>(employeeDTO,HttpStatus.OK);
	}

	@GetMapping(value="/employee")
	public ResponseEntity<List<EmployeeDTO>> getAllEmployees() throws SBIException {		
		List<EmployeeDTO> listEmployeeDTO  = employeeService.getAllEmployee();
		return new ResponseEntity<>(listEmployeeDTO,HttpStatus.OK);
	}

	@PostMapping(value = "/employee")
	public ResponseEntity<String> addEmployee(@RequestBody EmployeeDTO employeeDTO) throws SBIException{		
		Integer employeeId = employeeService.addEmployee(employeeDTO);
		String successMessage = environment.getProperty("API.EMPLOYEE_INSERT_SUCCESS") + employeeId;
		return new ResponseEntity<>(successMessage,HttpStatus.CREATED);
	}

	@PutMapping(value = "/employee/{employeeId}")
	public ResponseEntity<String> updateEmployee(@PathVariable Integer employeeId, @RequestBody EmployeeDTO employee)throws SBIException {
		employeeService.updateEmployee(employeeId, employee.getName());
		String successMessage = environment.getProperty("API.UPDATE_EMPLOYEE_SUCCESS");
		return new ResponseEntity<>(successMessage,HttpStatus.OK);
	}
//http://localhost:8085/sbibank/employee/1

}

package com.ibm.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.dto.EmployeeDTO;
import com.ibm.exception.InfyBankException;
import com.ibm.service.EmployeeService;

@RestController
@RequestMapping(value = "/infybank")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeAPI {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private Environment environment;
	
	
	@GetMapping(value = "/employees")
	public ResponseEntity<List<EmployeeDTO>> getAllEmployees() throws InfyBankException {
		List<EmployeeDTO> employeeDTOs = employeeService.getAllEmployees();
		return new ResponseEntity<>(employeeDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/employees/{id}")
	public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Integer id) throws InfyBankException {
		EmployeeDTO employeeDTO = employeeService.getEmployee(id);
		return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
	}	

	@PostMapping(value = "/employees")
	public ResponseEntity<String> addEmployee(@RequestBody EmployeeDTO employeeDTO) throws InfyBankException {
		Integer employeeId = employeeService.addEmployee(employeeDTO);
		String successMessage = environment.getProperty("EMP.INSERT_SUCCESS") + employeeId;
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/employees/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Integer id) throws InfyBankException {
		employeeService.deleteEmployee(id);
		String successMessage = environment.getProperty("API.DELETE_SUCCESS_EMP");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
	
	@PutMapping(value = "/employees/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable Integer id, @RequestBody EmployeeDTO employee)throws InfyBankException {
		
		System.out.println("Id:>>> " + id);
		System.out.println(employee);
		
		employeeService.updateEmployee(id, employee.getName(), employee.getRole());
		String successMessage = environment.getProperty("API.UPDATE_SUCCESS_EMP");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
	
}

package com.bhartIT.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhartIT.dto.EmployeeDto;
import com.bhartIT.entity.Employee;
import com.bhartIT.exception.NewSbiException;
import com.bhartIT.service.EmployeeService;

@RestController
@RequestMapping(value="/SBI")
public class EmployeeApi {
	
	//http://localhost:8085/SBI/employee
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private Environment environment;
	
	@GetMapping(value = "/employee/{employeeId}")
	public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Integer employeeId) throws NewSbiException
	{
		EmployeeDto employee = employeeService.getData(employeeId);
		System.out.println(employee); 
		return new ResponseEntity<>(employee,HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/employee")
	public ResponseEntity<List<EmployeeDto>> getAllEmployee() throws NewSbiException
	{
		List<EmployeeDto> employeeList = employeeService.getAllData();
		return new ResponseEntity<>(employeeList,HttpStatus.OK);
		
	}
	@PostMapping(value="/employee")
	public ResponseEntity<String> addEmployee(@RequestBody EmployeeDto employee) throws NewSbiException
	{
		Integer employeeId = employeeService.addEmployee(employee);
		String successMessage = environment.getProperty("API.INSERT_SUCCESS") + employeeId;
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
		
		
	}
	
	@DeleteMapping(value = "/employee/{employeeId}")
	public ResponseEntity<String> deleteData(@PathVariable Integer employeeId) throws NewSbiException
	{
	employeeService.deleteData(employeeId);
		
	try {
	 return ResponseEntity.ok("Item with ID " + employeeId + " deleted successfully");
	 } catch (Exception e) {
	 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
             .body("Error deleting item with ID " + employeeId);
	}
	}
	
	@PutMapping("/employee/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer employeeId, @RequestBody Employee updatedEmployee) {
        try {
            Employee updatedEntity = employeeService.updateEmployee(employeeId, updatedEmployee);
            return ResponseEntity.ok(updatedEntity);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
       
    }
}

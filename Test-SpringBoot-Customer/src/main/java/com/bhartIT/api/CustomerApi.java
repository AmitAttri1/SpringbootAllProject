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

import com.bhartIT.SBIException.SbiException;
import com.bhartIT.dto.CustomerDTO;
import com.bhartIT.sevice.CustomerService;

//http://localhost:8085/sbi/customers/1
@RestController
@RequestMapping(value = "/sbi")
public class CustomerApi {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private Environment environment;

	@GetMapping(value = "/customers/{customerId}")
	public ResponseEntity<CustomerDTO> getData(@PathVariable Integer customerId) throws SbiException {
		CustomerDTO customer = customerService.getEmployee(customerId);
		return new ResponseEntity<>(customer, HttpStatus.OK);

	}

	@GetMapping(value = "/customers")
	public ResponseEntity<List<CustomerDTO>> getAllData() throws SbiException {
		List<CustomerDTO> allEmployee = customerService.getAllEmployee();
		return new ResponseEntity<>(allEmployee, HttpStatus.OK);
	}
	@PostMapping(value = "/customers")
	public ResponseEntity<String> addData(@RequestBody CustomerDTO customer)throws SbiException
	{
		Integer customerId = customerService.addEmployee(customer);
		String successMessage = environment.getProperty("API.INSERT_SUCCESS")+customerId;
		
		return new ResponseEntity<>(successMessage,HttpStatus.OK);
		
	}
	@DeleteMapping(value = "/customers/{customerId}")
	public  ResponseEntity<String> deleteData(@PathVariable Integer customerId) throws SbiException {
		customerService.deletetEmployee(customerId);
		String successMessage = environment.getProperty("API.DELETE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
	@PutMapping(value = "/customers/{customerId}")
	public ResponseEntity<String> updateCustomer(@PathVariable Integer customerId, @RequestBody CustomerDTO customer) throws SbiException
	{
		customerService.updateEmployee(customerId, customer.getName());
		String successMessage = environment.getProperty("API.update_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
		
	}
}

package com.ibm.ecms.api;

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
import com.ibm.ecms.dto.CustomerDto;
import com.ibm.ecms.exception.INFbankexception;
import com.ibm.ecms.service.CustomerService;

@RestController
@RequestMapping(value = "infy")
@CrossOrigin(origins = "http://localhost:3000")

//http://localhost:8085/infy/customers
public class CustomerApi {
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private Environment environment;

	@GetMapping(value = "/customers/{customerId}")
	public ResponseEntity<CustomerDto> getCustomer(@PathVariable Integer customerId) throws INFbankexception {
		CustomerDto customer = customerService.getCustomer(customerId);

		return new ResponseEntity<>(customer, HttpStatus.OK);

	}
	
	@GetMapping(value = "/customers")
	public ResponseEntity<List<CustomerDto>> getAllCustomer() throws INFbankexception{
		List<CustomerDto> allCustomer = customerService.getAllCustomer();
		return new ResponseEntity<>(allCustomer,HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/customers")
	public ResponseEntity<String>addAllCustomer( @RequestBody CustomerDto customer) throws INFbankexception
	{
		Integer cuatomerId = customerService.addAllCustomer(customer);
		String successmessage = environment.getProperty("API.INSERT_SUCCESS")+cuatomerId;
		
		return new ResponseEntity<>(successmessage,HttpStatus.CREATED);
		
		
	}
	@PutMapping(value = "/customers/{customerId}")
	public ResponseEntity <String> updateCustomer(@PathVariable Integer CustomerId, @RequestBody CustomerDto customer) throws INFbankexception
	{
		customerService.updateCustomer(CustomerId, customer.getEmailId());
		String successMessage = environment.getProperty("API.Update_SUCCESS");
		return new ResponseEntity<>(successMessage,HttpStatus.OK);
		
	}
	@DeleteMapping(value = "/customers/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Integer customerId) throws INFbankexception {
		customerService.deleteCustomer(customerId);
		String successMessage = environment.getProperty("API.DELETE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}

}
//http://localhost:8085/infy/customers/1
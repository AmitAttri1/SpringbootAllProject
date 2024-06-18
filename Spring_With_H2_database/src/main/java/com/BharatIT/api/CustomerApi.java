package com.BharatIT.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BharatIT.Icici_Bank_Exception.IciciBankException;
import com.BharatIT.dto.CustomerDto;
import com.BharatIT.service.CustomerService;

@RestController
@RequestMapping(value = "/hdfcbank")
public class CustomerApi {
//http://localhost:8080/hdfcbank/customers
	@Autowired
	private CustomerService customerService;

	private Environment environment;
	

	@GetMapping(value = "/customers")
	public ResponseEntity<List<CustomerDto>> getAllCustomer() throws IciciBankException
	{
		List<CustomerDto> allData = customerService.getAllData();
		return new ResponseEntity<>(allData, HttpStatus.OK);

	}

	@GetMapping(value = "/customers/{customerId}")
	public ResponseEntity<CustomerDto> getData(@PathVariable Integer customerId)throws IciciBankException
	{
		CustomerDto data = customerService.getData(customerId);
		
		
		return new ResponseEntity<>(data, HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/customers")
	public ResponseEntity<String> addCustomer(@RequestBody CustomerDto customer)throws IciciBankException
	{
		
		Integer customerId = customerService.addData(customer);
		String successMessage = environment.getProperty("API.INSERT_SUCCESS") + customerId;
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
		
	}
}

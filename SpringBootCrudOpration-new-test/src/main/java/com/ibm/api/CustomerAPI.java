package com.ibm.api;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.dto.CustomerDto;
import com.ibm.exception.HDFException;
import com.ibm.service.CustomerService;


@RestController
@RequestMapping(value = "/hdfcbank")
public class CustomerAPI {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private Environment environment;
	
	@GetMapping(value = "/customers/{customerId}")
	public ResponseEntity<CustomerDto> getCustomer(@PathVariable Integer customerId) throws HDFException
	{
		CustomerDto customer = customerService.getCustomer(customerId);
		
		return new ResponseEntity<>(customer,HttpStatus.OK);
		
	}

}

package com.ibm.ecms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.ecms.dto.CustomerDto;
import com.ibm.ecms.exception.HdfcException;
import com.ibm.ecms.service.CustomerService;

@RestController
@RequestMapping(value = "hdfc")
public class CustomerApi {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value = "/customers/{customerId}")
	public ResponseEntity<CustomerDto> getCustomer(@PathVariable Integer customerId)throws HdfcException
	
	{
		
		CustomerDto customer = customerService.getCustomer(customerId);
	
		
		return new ResponseEntity<>(customer,HttpStatus.OK);
		
	}//http://localhost:8085/hdfc/customers/2
	
	@GetMapping(value = "customers")
	public ResponseEntity<List<CustomerDto>> getAllCustomer()throws HdfcException
	{
		List<CustomerDto> allCustomer = customerService.getAllCustomer();
		return new ResponseEntity<>(allCustomer,HttpStatus.OK);
		
	}

}

package com.ibm.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.dto.CustomerDTO;
import com.ibm.exception.SBIException;
import com.ibm.service.CustomerService;





@RestController
@RequestMapping(value = "/sbibank")
public class CustomerAPI {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private Environment environment;
	
	
	@GetMapping(value = "/customers/{customerId}")
	public ResponseEntity<CustomerDTO> getCustomer(@PathVariable Integer customerId) throws SBIException {
		
		
		System.out.println("customerId "+customerId);
		CustomerDTO customer = customerService.getCustomer(customerId);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
	
	/*
	 * @GetMapping(value = "/customers") public ResponseEntity<List<CustomerDTO>>
	 * getAllCustomers() throws HDFCBankException { List<CustomerDTO> customerList =
	 * customerService.getAllCustomers(); return new ResponseEntity<>(customerList,
	 * HttpStatus.OK); }
	 * 
	 * @PostMapping(value = "/customers") public ResponseEntity<String>
	 * addCustomer(@RequestBody CustomerDTO customer) throws HDFCBankException {
	 * Integer customerId = customerService.addCustomer(customer); String
	 * successMessage = environment.getProperty("API.INSERT_SUCCESS") + customerId;
	 * return new ResponseEntity<>(successMessage, HttpStatus.CREATED); }
	 * 
	 * @PutMapping(value = "/customers/{customerId}") public ResponseEntity<String>
	 * updateCustomer(@PathVariable Integer customerId, @RequestBody CustomerDTO
	 * customer)throws HDFCBankException {
	 * customerService.updateCustomer(customerId, customer.getEmailId()); String
	 * successMessage = environment.getProperty("API.UPDATE_SUCCESS"); return new
	 * ResponseEntity<>(successMessage, HttpStatus.OK); }
	 * 
	 * @DeleteMapping(value = "/customers/{customerId}") public
	 * ResponseEntity<String> deleteCustomer(@PathVariable Integer customerId)
	 * throws HDFCBankException { customerService.deleteCustomer(customerId); String
	 * successMessage = environment.getProperty("API.DELETE_SUCCESS"); return new
	 * ResponseEntity<>(successMessage, HttpStatus.OK); }
	 */
}

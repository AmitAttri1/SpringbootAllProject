package api;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.CustomerDTO;
import service.CustomerService;
@RestController
@RequestMapping(value = "HDFCbank")
public class CustomerAPI {
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private Environment environment;
	
	
	@GetMapping(value = "/customers/{customerId}")
	public ResponseEntity<CustomerDTO> getCustomerDetails(@PathVariable Integer customerId) throws Exception {
		CustomerDTO customer = customerService.getCustomer(customerId);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
	
//http://localhost:8085/HDFCbank/customers/1
}

package service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dto.CustomerDTO;
import entity.Customer;
import exception.HDFbankException;
import repositry.CustomerRespository;

@Service(value = "customerService")
@Transactional
public class CustomerServiceImp implements CustomerService {

	@Autowired
	private CustomerRespository customerRespository;

	@Override
	public CustomerDTO getCustomer(Integer customerId) throws HDFbankException {
		Optional<Customer> optional = customerRespository.findById(customerId);
		Customer customer = optional.orElseThrow(() -> new HDFbankException("Service.CUSTOMER_NOT_FOUND"));

		CustomerDTO customerDTO = new CustomerDTO();

		customerDTO.setCustomerId(customer.getCustomerId());
		customerDTO.setName(customer.getName());
		customerDTO.setEmailId(customer.getEmailId());
		customerDTO.setDateOfBirth(customer.getDateOfBirth());

		return customerDTO;
	}

}

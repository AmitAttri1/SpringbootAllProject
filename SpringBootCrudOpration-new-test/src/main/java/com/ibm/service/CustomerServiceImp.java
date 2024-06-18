package com.ibm.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ibm.Repository.CustomerRepository;
import com.ibm.dto.CustomerDto;
import com.ibm.entity.Customer;
import com.ibm.exception.HDFException;


@Service(value ="customerService")
@Transactional
public class CustomerServiceImp implements CustomerService{

	private CustomerRepository customerRepository;
	@Override
	public CustomerDto getCustomer(Integer customerId) throws HDFException {
		Optional<Customer> optional = customerRepository.findById(customerId);
		Customer customer = optional.orElseThrow(()-> new HDFException("Service.CUSTOMER_NOT_FOUND"));
		
		CustomerDto customerDto=new CustomerDto();
		customerDto.setCustomerId(customer.getCustomerId());
		customerDto.setName(customer.getName());
		customerDto.setDateOfBirth(customer.getDateOfBirth());
		customerDto.setEmailId(customer.getEmailId());
		return customerDto;
		
		
	}
	

}

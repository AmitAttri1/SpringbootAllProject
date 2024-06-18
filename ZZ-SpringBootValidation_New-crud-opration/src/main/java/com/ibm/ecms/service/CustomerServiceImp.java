package com.ibm.ecms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ibm.ecms.dto.CustomerDto;
import com.ibm.ecms.entity.Customer;
import com.ibm.ecms.exception.InfybankException;
import com.ibm.ecms.repository.CustomerRepository;

import jakarta.transaction.Transactional;


@Service(value = "customerService")
@Transactional
public class CustomerServiceImp implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public CustomerDto getCustomer(Integer custmerId) throws InfybankException {
		Optional<Customer> optional = customerRepository.findById(custmerId);
		Customer customer = optional.orElseThrow(() -> new InfybankException(":some error accurd please check "));

		CustomerDto customerDto = new CustomerDto();
		customerDto.setCustomerId(customer.getCustomerId());
		customerDto.setName(customer.getName());
		customerDto.setEmailId(customer.getEmailId());
		customerDto.setDateOfBirth(customer.getDateOfBirth());
		return customerDto;
	}

	@Override
	public List<CustomerDto> getAllCustomers() throws InfybankException {
		
		Iterable<Customer> iterableCustomer = customerRepository.findAll();
		List<CustomerDto> customerList=new ArrayList<>();
		iterableCustomer.forEach(customer->{
			CustomerDto customerdto=new CustomerDto();
			customerdto.setCustomerId(customer.getCustomerId());
			customerdto.setName(customer.getName());
			customerdto.setDateOfBirth(customer.getDateOfBirth());
			customerdto.setEmailId(customer.getEmailId());
			customerList.add(customerdto);
		});
		if (customerList.isEmpty())
			throw new InfybankException("Service.CUSTOMERS_NOT_FOUND");
		return customerList;
	}

	

}

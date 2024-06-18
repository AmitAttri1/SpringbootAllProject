package com.BharatIT.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.BharatIT.Icici_Bank_Exception.IciciBankException;
import com.BharatIT.dto.CustomerDto;
import com.BharatIT.entity.Customer;
import com.BharatIT.repository.CustomerRepository;

@Service

public class CustomerServiceImp implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private Environment environment;

	@Override
	public List<CustomerDto> getAllData() throws IciciBankException {
		Iterable<Customer> customers = customerRepository.findAll();

		List<CustomerDto> customer2 = new ArrayList<>();
		customers.forEach(customerd -> {
			CustomerDto custDto = new CustomerDto();

			custDto.setCustomer_id(customerd.getCustomer_id());
			custDto.setDate_of_birth(customerd.getDate_of_birth());
			custDto.setEmail_id(customerd.getEmail_id());
			custDto.setName(customerd.getName());

			customer2.add(custDto);

		});

		if (customer2.isEmpty()) {
			throw new IciciBankException("Service.CUSTOMERS_NOT_FOUND");

		}

		return customer2;
	}

	@Override
	public CustomerDto getData(int customerId) throws IciciBankException {
		
		Optional<Customer> optional = customerRepository.findById(customerId);
		Customer customer = optional.orElseThrow(()->new IciciBankException("Service.EMPLOYEE_NOT_FOUND"));
		CustomerDto customDto=new CustomerDto();
		
		customDto.setCustomer_id(customer.getCustomer_id());
		customDto.setDate_of_birth(customer.getDate_of_birth());
		customDto.setEmail_id(customer.getEmail_id());
		customDto.setName(customer.getName());
		return customDto;
	}
	
	public Integer addData(CustomerDto Customer)throws IciciBankException{
		
		Customer customerEntity=new Customer();
		
		customerEntity.setCustomer_id(Customer.getCustomer_id());
		customerEntity.setDate_of_birth(Customer.getDate_of_birth());
		customerEntity.setEmail_id(Customer.getEmail_id());
		customerEntity.setName(Customer.getName());
		
		Customer customerEntity2 = customerRepository.save(customerEntity);
		
		return customerEntity2.getCustomer_id();
		
	}



}

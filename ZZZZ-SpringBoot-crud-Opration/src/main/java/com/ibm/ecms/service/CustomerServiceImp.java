package com.ibm.ecms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import com.ibm.ecms.dto.CustomerDto;
import com.ibm.ecms.entity.Customer;
import com.ibm.ecms.exception.HdfcException;
import com.ibm.ecms.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerServiceImp implements CustomerService{
	
@Autowired
private	CustomerRepository customerRepository;
	@Override
	public CustomerDto getCustomer(Integer customerId) throws HdfcException {
		Optional<Customer> optional = customerRepository.findById(customerId);
		Customer customer = optional.orElseThrow(()-> new HdfcException("Service.CUSTOMERS_NOT_FOUND"));
		CustomerDto customerDto=new CustomerDto();
		customerDto.setCustomerId(customer.getCustomerId());
		customerDto.setDateOfBirth(customer.getDateOfBirth());
		customerDto.setEmailId(customer.getEmailId());
		customerDto.setName(customer.getName());
		
		return customerDto;
	}
	@Override
	public List<CustomerDto> getAllCustomer() throws HdfcException {
		Iterable<Customer> iterablecustomer = customerRepository.findAll();
		List<CustomerDto>cutomerlist=new ArrayList<>();
		iterablecustomer.forEach(customer->{
			
			CustomerDto customerDto=new CustomerDto();
			
			customerDto.setCustomerId(customer.getCustomerId());
			customerDto.setDateOfBirth(customer.getDateOfBirth());
			customerDto.setEmailId(customer.getEmailId());
			customerDto.setName(customer.getName());
			cutomerlist.add(customerDto);
		});
		if(cutomerlist.isEmpty())
		{
			throw new HdfcException("Service.CUSTOMERS_NOT_FOUND");
		}
		return cutomerlist;
	}
	@Override

	public CustomerDto UpdateCustomer(Integer customerId) throws HdfcException {
		Optional<Customer> findById = customerRepository.findById(customerId);
		
		return null;
	}

}

package com.ibm.ecms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ibm.ecms.dto.CustomerDto;
import com.ibm.ecms.entity.Customer;
import com.ibm.ecms.exception.INFbankexception;
import com.ibm.ecms.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Service(value = "customerService")
@Transactional

public class CustomerServiceImp implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public CustomerDto getCustomer(Integer CustomerId) throws INFbankexception {
		Optional<Customer> optional = customerRepository.findById(CustomerId);
		Customer customer = optional.orElseThrow(()-> new INFbankexception("Service.CUSTOMERS_NOT_FOUND"));
		
		CustomerDto customerDto=new CustomerDto();
		
		customerDto.setCustomerId(customer.getCustomerId());
		customerDto.setName(customer.getName());
		customerDto.setDateOfBirth(customer.getDateOfBirth());
		customerDto.setEmailId(customer.getEmailId());
		
		return customerDto;
	}

	@Override
	public List<CustomerDto> getAllCustomer() throws INFbankexception {
		Iterable<Customer> IterableCustomer = customerRepository.findAll();
		List<CustomerDto>cutomerlist=new ArrayList<>();
		IterableCustomer.forEach(customer->{
			CustomerDto customerDto=new CustomerDto();
			customerDto.setCustomerId(customer.getCustomerId());
			customerDto.setName(customer.getName());
			customerDto.setEmailId(customer.getEmailId());
			customerDto.setDateOfBirth(customer.getDateOfBirth());
			cutomerlist.add(customerDto);
			
		});
		if(cutomerlist.isEmpty())
		{
			throw new INFbankexception("Service.CUSTOMERS_NOT_FOUND");
		}
		return cutomerlist;
	}

	@Override
	public Integer addAllCustomer(CustomerDto customer) throws INFbankexception {
		
		Customer customerentity=new Customer();
		
		customerentity.setCustomerId(customer.getCustomerId());
		customerentity.setName(customer.getName());
		customerentity.setEmailId(customer.getEmailId());
		customerentity.setDateOfBirth(customer.getDateOfBirth());
		Customer customerEntity2 = customerRepository.save(customerentity);
		return customerEntity2.getCustomerId();
	}

	@Override
	public void updateCustomer(Integer CustomerId, String emailId) throws INFbankexception {
		Optional<Customer> customer = customerRepository.findById(CustomerId);
		Customer c = customer.orElseThrow(()-> new INFbankexception("Service.CUSTOMERS_Updated_FOUND"));
		c.setEmailId(emailId);
		customerRepository.save(c);
	}

	@Override
	public void deleteCustomer(Integer customerId) throws INFbankexception {
		Optional<Customer> customer = customerRepository.findById(customerId);
		customer.orElseThrow(() -> new INFbankexception("Service.CUSTOMER_NOT_FOUND"));
		customerRepository.deleteById(customerId);
	}

	

	
}

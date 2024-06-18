package com.bhartIT.sevice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.bhartIT.SBIException.SbiException;
import com.bhartIT.dto.CustomerDTO;
import com.bhartIT.entity.Customer;
import com.bhartIT.repository.CustomerRepository;

@Service
public class CustomerServiceImp implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private Environment environment;

	@Override
	public CustomerDTO getEmployee(Integer customerId) throws SbiException {

		Optional<Customer> optional = customerRepository.findById(customerId);
		Customer customer = optional.orElseThrow(() -> new SbiException("service.Customer_not_found"));
		
		CustomerDTO customerDTO=new CustomerDTO();
		customerDTO.setCustomerId(customer.getCustomerId());
		customerDTO.setDataOfBirth(customer.getDataOfBirth());
		customerDTO.setEmailId(customer.getEmailId());
		customerDTO.setName(customer.getName());
		
		return customerDTO;
	}

	@Override
	public List<CustomerDTO> getAllEmployee() throws SbiException {
		
		Iterable<Customer> iterableCustomer = customerRepository.findAll();
		
		List<CustomerDTO>customerlist=new ArrayList<>();
		
		iterableCustomer.forEach(customer->{
			CustomerDTO customerDTO=new CustomerDTO();
	
			customerDTO.setCustomerId(customer.getCustomerId());
			customerDTO.setDataOfBirth(customer.getDataOfBirth());
			customerDTO.setEmailId(customer.getEmailId());
			customerDTO.setName(customer.getName());
			customerlist.add(customerDTO);
			
		});
		
		return customerlist;
	}

	@Override
	public Integer addEmployee(CustomerDTO customer) throws SbiException {
		
		Customer customerEntity=new Customer();
		
		customerEntity.setCustomerId(customer.getCustomerId());
		customerEntity.setDataOfBirth(customer.getDataOfBirth());
		customerEntity.setEmailId(customer.getEmailId());
		customerEntity.setName(customer.getName());
		
		Customer customerid = customerRepository.save(customerEntity);
		
		return customerid.getCustomerId();
	}

	

	@Override
	public void deletetEmployee(Integer customerId) throws SbiException {
		
		Optional<Customer> optional = customerRepository.findById(customerId);
		 optional.orElseThrow(()-> new SbiException("service.Customer_delete"));
		customerRepository.deleteById(customerId);
		
		
	}

	@Override
	public void updateEmployee(Integer customerId, String name) throws SbiException {
		
		Optional<Customer> optional = customerRepository.findById(customerId);
		
		Customer customer = optional.orElseThrow(()-> new SbiException("service.Customer_update"));
		customer.setName(name);
		customerRepository.save(customer);
		
	}

	

}

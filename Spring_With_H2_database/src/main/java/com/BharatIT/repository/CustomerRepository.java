package com.BharatIT.repository;

import org.springframework.data.repository.CrudRepository;

import com.BharatIT.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{

}

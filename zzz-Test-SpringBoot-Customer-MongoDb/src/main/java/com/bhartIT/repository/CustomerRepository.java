package com.bhartIT.repository;

import org.springframework.data.repository.CrudRepository;

import com.bhartIT.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}

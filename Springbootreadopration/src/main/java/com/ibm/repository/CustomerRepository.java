package com.ibm.repository;



import org.springframework.data.repository.CrudRepository;

import com.ibm.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}

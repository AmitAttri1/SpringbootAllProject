package repositry;

import org.springframework.data.repository.CrudRepository;

import entity.Customer;

public interface CustomerRespository extends CrudRepository<Customer, Integer>{

}

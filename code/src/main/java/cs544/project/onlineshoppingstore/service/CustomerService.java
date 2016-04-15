package cs544.project.onlineshoppingstore.service;

import java.util.List;

import cs544.project.onlineshoppingstore.model.Customer;

public interface CustomerService {

	Customer get(long id);
	List<Customer> getAll();
	void create(Customer customer);
	void update(long id, Customer updatedCustomer);
	void delete(long id);
	
	List<Customer> findByName(String name);
	List<Customer> findByEmail(String email);
}

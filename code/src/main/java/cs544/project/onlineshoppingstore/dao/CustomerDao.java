package cs544.project.onlineshoppingstore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cs544.project.onlineshoppingstore.model.Customer;

public interface CustomerDao extends JpaRepository<Customer, Long>{
	
	List<Customer> findByName(String name);
	List<Customer> findByEmail(String email);
}

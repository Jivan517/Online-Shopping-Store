package cs544.project.onlineshoppingstore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cs544.project.onlineshoppingstore.model.BilingAddress;
import cs544.project.onlineshoppingstore.model.Customer;

public interface BillingAddressDao extends JpaRepository<BilingAddress, Long>{
	
	List<BilingAddress> findByState(String state);
	BilingAddress findByCustomer(Customer customer);
	
}

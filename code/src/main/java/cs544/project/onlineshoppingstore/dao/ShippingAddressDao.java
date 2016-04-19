package cs544.project.onlineshoppingstore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cs544.project.onlineshoppingstore.model.Customer;
import cs544.project.onlineshoppingstore.model.ShippingAddress;

public interface ShippingAddressDao extends JpaRepository<ShippingAddress, Long>{

	List<ShippingAddress> findByState(String state);
	ShippingAddress findByCustomer(Customer customer);
	
}

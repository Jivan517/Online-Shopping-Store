package cs544.project.onlineshoppingstore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cs544.project.onlineshoppingstore.model.BilingAddress;

public interface BillingAddressDao extends JpaRepository<BilingAddress, Long>{
	
	List<BilingAddress> findByState(String state);

}

package cs544.project.onlineshoppingstore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cs544.project.onlineshoppingstore.model.Shipping;
import cs544.project.onlineshoppingstore.model.ShippingType;

public interface ShippingDao extends JpaRepository<Shipping, Long>{

	
	List<Shipping> findByShippingType(ShippingType shippingType);
}

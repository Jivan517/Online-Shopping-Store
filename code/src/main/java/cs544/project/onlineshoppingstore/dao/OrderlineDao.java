package cs544.project.onlineshoppingstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cs544.project.onlineshoppingstore.model.Orderline;

public interface OrderlineDao extends JpaRepository<Orderline, Long>{

	
}

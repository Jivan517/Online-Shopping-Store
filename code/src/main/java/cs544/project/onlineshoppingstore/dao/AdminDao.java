package cs544.project.onlineshoppingstore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cs544.project.onlineshoppingstore.model.Admin;

public interface AdminDao  extends JpaRepository<Admin, Long>{
	
	List<Admin> findByName(String name);
	List<Admin> findByEmail(String email);

}

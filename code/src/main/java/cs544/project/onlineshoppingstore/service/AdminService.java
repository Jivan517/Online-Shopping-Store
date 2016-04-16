package cs544.project.onlineshoppingstore.service;

import java.util.List;

import cs544.project.onlineshoppingstore.model.Admin;

public interface AdminService {

	Admin get(long id);
	List<Admin> getAll();
	void create(Admin admin);
	void update(long id, Admin updatedCustomer);
	void delete(long id);
	
	List<Admin> findByName(String name);
	List<Admin> findByEmail(String email);
}

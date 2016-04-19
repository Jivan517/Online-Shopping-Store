package cs544.project.onlineshoppingstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.project.onlineshoppingstore.dao.AdminDao;
import cs544.project.onlineshoppingstore.model.Admin;

@Transactional(propagation = Propagation.REQUIRED)
@Component
public class AdminServiceImpl implements AdminService{
	
	
	private AdminDao adminDao;
	
	@Autowired
	public void setAdminDao(AdminDao adminDao)
	{
		this.adminDao=adminDao;
	}
	
	@Override
	public Admin get(long id) {
		return adminDao.findOne(id);
	}

	@Override
	public List<Admin> getAll() {
		return adminDao.findAll();
	}

	@Override
	public void create(Admin admin) {
		adminDao.save(admin);
	}

	@Override
	public void update(long id, Admin updatedAdmin) {
		adminDao.save(updatedAdmin);
	}

	@Override
	public void delete(long id) {
		adminDao.delete(id);
	}

	@Override
	public List<Admin> findByName(String name) {
		return adminDao.findByName(name);
	}

	@Override
	public List<Admin> findByEmail(String email) {
		return adminDao.findByEmail(email);
	}

}

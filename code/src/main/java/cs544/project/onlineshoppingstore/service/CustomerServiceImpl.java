package cs544.project.onlineshoppingstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.project.onlineshoppingstore.dao.CustomerDao;
import cs544.project.onlineshoppingstore.model.Customer;

@Transactional(propagation = Propagation.REQUIRED)
public class CustomerServiceImpl implements CustomerService{

	private CustomerDao customerDao;
	
	@Autowired
	public void setCustomerDao(CustomerDao customerDao)
	{
		this.customerDao=customerDao;
	}
	
	@Override
	public Customer get(long id) {
	return customerDao.findOne(id);
	}

	@Override
	public List<Customer> getAll() {
		return customerDao.findAll();
	}

	@Override
	public void create(Customer customer) {
		customerDao.save(customer);
		
	}

    @Override
	public void update(long id, Customer updatedCustomer) {
	    customerDao.save(updatedCustomer);
		
	}

	@Override
	public void delete(long id) {
		customerDao.delete(id);
		
	}

	@Override
	public List<Customer> findByName(String name) {
		return customerDao.findByName(name);
	}

	@Override
	public List<Customer> findByEmail(String email) {
		return customerDao.findByEmail(email);
	}

}

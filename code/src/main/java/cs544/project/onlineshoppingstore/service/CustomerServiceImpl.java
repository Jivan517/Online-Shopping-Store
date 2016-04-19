package cs544.project.onlineshoppingstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.project.onlineshoppingstore.dao.BillingAddressDao;
import cs544.project.onlineshoppingstore.dao.CustomerDao;
import cs544.project.onlineshoppingstore.dao.ShippingAddressDao;
import cs544.project.onlineshoppingstore.model.BilingAddress;
import cs544.project.onlineshoppingstore.model.Customer;
import cs544.project.onlineshoppingstore.model.ShippingAddress;

@Transactional(propagation = Propagation.REQUIRED)
@Component
public class CustomerServiceImpl implements CustomerService{

	private CustomerDao customerDao;
	
	@Autowired
	private ShippingAddressDao shippingAddressDao;
	
	@Autowired
	private BillingAddressDao bilingAddressDao;
	
	
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
		Customer customerPersisted = customerDao.save(customer);
		BilingAddress billAddr = customer.getBilingAddress();
		billAddr.setCustomer(customerPersisted);
		bilingAddressDao.save(billAddr);
		ShippingAddress shipAddr = customer.getShipingAddress();
		shipAddr.setCustomer(customerPersisted);
		shippingAddressDao.save(shipAddr);
	
	}

    @Override
	public void update(long id, Customer updatedCustomer) {
    	
    	System.out.println(updatedCustomer.getShipingAddress().getId());
    	System.out.println(updatedCustomer.getBilingAddress().getId());
    	updatedCustomer.setId(id);
    	BilingAddress billAddr = updatedCustomer.getBilingAddress();
		billAddr.setCustomer(updatedCustomer);
		bilingAddressDao.save(billAddr);
		ShippingAddress shipAddr = updatedCustomer.getShipingAddress();
		shipAddr.setCustomer(updatedCustomer);
		shippingAddressDao.save(shipAddr);
    	Customer customerPersisted = customerDao.save(updatedCustomer);
		
		
	}

	@Override
	public void delete(long id) {
		Customer customerPersisted = customerDao.getOne(id);
		BilingAddress billAddr = customerPersisted.getBilingAddress();
		bilingAddressDao.delete(billAddr);
		ShippingAddress shipAddr = customerPersisted.getShipingAddress();
		shippingAddressDao.delete(shipAddr);
		customerDao.delete(customerPersisted);
		
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

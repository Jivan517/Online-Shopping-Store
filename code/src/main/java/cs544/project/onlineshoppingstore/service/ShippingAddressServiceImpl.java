package cs544.project.onlineshoppingstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.project.onlineshoppingstore.dao.ShippingAddressDao;
import cs544.project.onlineshoppingstore.model.ShippingAddress;

@Transactional(propagation = Propagation.REQUIRED)
@Component
public class ShippingAddressServiceImpl implements ShippingAddressService{

	private ShippingAddressDao shippingAddressDao;
	
	@Autowired
	public void setShippingAddressDao(ShippingAddressDao shippingAddressDao)
	{
		this.shippingAddressDao=shippingAddressDao;
	}
	
	@Override
	public ShippingAddress get(long shippingId) {
		return shippingAddressDao.findOne(shippingId);
	}

	@Override
	public List<ShippingAddress> getAll() {
		return shippingAddressDao.findAll();
	}

	@Override
	public void create(ShippingAddress shippingAddress) {
		shippingAddressDao.save(shippingAddress);
		
	}

	@Override
	public void update(long id, ShippingAddress updatedShippingAddress) {
		shippingAddressDao.save(updatedShippingAddress);		
	}

	@Override
	public void delete(long shippingId) {
		shippingAddressDao.delete(shippingId);
		
	}

	@Override
	public List<ShippingAddress> findByState(String state) {
		return shippingAddressDao.findByState(state);
	}

}

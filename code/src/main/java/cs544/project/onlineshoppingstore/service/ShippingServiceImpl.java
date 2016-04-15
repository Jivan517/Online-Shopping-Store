package cs544.project.onlineshoppingstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.project.onlineshoppingstore.dao.ShippingDao;
import cs544.project.onlineshoppingstore.model.Shipping;
import cs544.project.onlineshoppingstore.model.ShippingType;

@Transactional(propagation = Propagation.REQUIRED)
@Component
public class ShippingServiceImpl implements ShippingService {

	private ShippingDao shippingDao;
	
	@Autowired
	public void setShippingDao(ShippingDao shippingDao){
		this.shippingDao = shippingDao;
	}
	
	
	@Override
	public Shipping get(long shippingId) {
		return shippingDao.findOne(shippingId);
	}

	@Override
	public List<Shipping> getAll() {
		return shippingDao.findAll();
	}

	@Override
	public void create(Shipping shipping) {
		shippingDao.save(shipping);
		
	}

	@Override
	public void update(long id, Shipping updatedShipping) {
		shippingDao.save(updatedShipping);
		
	}

	@Override
	public void delete(long shippingId) {
		shippingDao.delete(shippingId);
		
	}

	@Override
	public List<Shipping> findByShippingType(ShippingType shippingType) {
		return shippingDao.findByShippingType(shippingType);
				
	}

}

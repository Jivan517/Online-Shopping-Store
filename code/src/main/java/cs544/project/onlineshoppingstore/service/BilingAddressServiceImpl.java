package cs544.project.onlineshoppingstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.project.onlineshoppingstore.dao.BillingAddressDao;
import cs544.project.onlineshoppingstore.model.BilingAddress;

@Transactional(propagation = Propagation.REQUIRED)
public class BilingAddressServiceImpl implements BilingAddressService{

	private BillingAddressDao billingAddressDao;
	
	@Autowired
	public void setBilingAddressDao(BillingAddressDao bilingAddressDao) {
		this.billingAddressDao = bilingAddressDao;
	}
	
	@Override
	public BilingAddress get(long bilingAddressId) {
		return billingAddressDao.findOne(bilingAddressId);
	}

	@Override
	public List<BilingAddress> getAll() {
		return billingAddressDao.findAll();
	}

	@Override
	public void create(BilingAddress bilingAddress) {
		billingAddressDao.save(bilingAddress);
		
	}

	@Override
	public void update(long id, BilingAddress updatedBilingAddress) {
		billingAddressDao.save(updatedBilingAddress);
		
	}

	@Override
	public void delete(long BilingAddressId) {
		billingAddressDao.delete(BilingAddressId);
		
	}

	@Override
	public List<BilingAddress> findByState(String state) {
	return billingAddressDao.findByState(state);
	}

}

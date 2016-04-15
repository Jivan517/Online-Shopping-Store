package cs544.project.onlineshoppingstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.project.onlineshoppingstore.dao.PublisherDao;
import cs544.project.onlineshoppingstore.model.Publisher;

@Transactional(propagation= Propagation.REQUIRED)
public class PublisherServiceImpl implements PublisherService{
	
	private PublisherDao publisherDao;
	
	@Autowired
	public void setPublisherDao(PublisherDao publisherDao){
		this.publisherDao = publisherDao;
	}

	@Override
	public Publisher get(long publisherId) {
		return publisherDao.getOne(publisherId);
	}

	@Override
	public List<Publisher> getAll() {
		return publisherDao.findAll();
	}

	@Override
	public void create(Publisher publisher) {
		publisherDao.save(publisher);
		
	}

	@Override
	public void update(long id, Publisher publisher) {
		publisherDao.save(publisher);
	}

	@Override
	public void delete(long publisherId) {
		publisherDao.delete(publisherId);
		
	}

	@Override
	public List<Publisher> findByName(String name) {
		return publisherDao.findByName(name);
	}

}

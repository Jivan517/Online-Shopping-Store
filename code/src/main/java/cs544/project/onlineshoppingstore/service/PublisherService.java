package cs544.project.onlineshoppingstore.service;

import java.util.List;


import cs544.project.onlineshoppingstore.model.Publisher;

public interface PublisherService {
	
	Publisher get(long publisherId);
	List<Publisher> getAll();
	void create(Publisher publisher);
	void update(long id, Publisher publisher);
	void delete(long publisherId);
	List<Publisher> findByName(String name);	

}

package cs544.project.onlineshoppingstore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cs544.project.onlineshoppingstore.model.Book;
import cs544.project.onlineshoppingstore.model.Publisher;



public interface PublisherDao extends JpaRepository<Publisher,Long>{
	
	List<Publisher> findByName(String name);	
	

}

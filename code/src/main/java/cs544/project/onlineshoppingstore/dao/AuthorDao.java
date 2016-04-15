package cs544.project.onlineshoppingstore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cs544.project.onlineshoppingstore.model.Author;



public interface AuthorDao extends JpaRepository<Author,Long>{
	
	List<Author> findByFirstName(String title);
	
	List<Author> findById(String isbn); 
	
	List<Author> findByLastName(String isbn);
	
	//List<Author> findByBookTitle(String author);
	

	
	
}

package cs544.project.onlineshoppingstore.service;

import java.util.List;


import cs544.project.onlineshoppingstore.model.Author;


public interface AuthorService {
	
	Author get(long authorID);
	List<Author> getAll();
	void create(Author author);
	void update(long id, Author author);
	void delete(long authorId);
	List<Author> findByFirstName(String firstName);	
	List<Author> findById(long id); 	
	List<Author> findByLastName(String lastName);
	List<Author> findByTitle(String title);	
	
 
}

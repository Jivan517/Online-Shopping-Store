package cs544.project.onlineshoppingstore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cs544.project.onlineshoppingstore.model.Book;

public interface BookDao extends JpaRepository<Book,Long>{
	
	List<Book> findByTitleLike(String title);
	
	List<Book> findByIsbn(String isbn); 
	
	List<Book> findById(String isbn);
	
	/*List<Book> findByAuthor(String author);
	
	List<Book> findByCategory(String category);
	
	List<Book> findByPublisher(String publisher);
	
	List<Book> findByRating(String rating);*/
	
	

}

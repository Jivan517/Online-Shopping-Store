package cs544.project.onlineshoppingstore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cs544.project.onlineshoppingstore.model.Book;

public interface BookDao extends JpaRepository<Book,Long>, BookDaoCustom{
	
	List<Book> findByTitleLike(String title);
	
	List<Book> findByIsbn(String isbn); 
	
	List<Book> findById(long id);
	
	List<Book> findFirst10ByOrderByPriceAsc();
	
	/*List<Book> findByCategory(String category);
	
	List<Book> findByPublisher(String publisher);
	
	List<Book> findByRating(String rating);*/
	
	

}

package cs544.project.onlineshoppingstore.service;

import java.util.List;

import cs544.project.onlineshoppingstore.model.Book;
import cs544.project.onlineshoppingstore.model.BookCategory;

public interface BookService {
	
	void create(Book book);
	void update(long id,Book book);
	void delete(long id);
	List<Book> findByTitleLike(String title);	
	List<Book> findByIsbn(String isbn);	
	List<Book> findById(long isbn);
	Book get(long id);
	List<Book> getAll();
	List<Book> findByFullTextSearch(String searchText);
	List<Book> findFirst10ByOrderByPriceAsc();
	List<Book> findBybookCategory(BookCategory category);

}

package cs544.project.onlineshoppingstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.project.onlineshoppingstore.dao.BookDao;
import cs544.project.onlineshoppingstore.model.Book;

@Transactional(propagation= Propagation.REQUIRED)
public class BookServiceImpl implements BookService{

	private BookDao bookDao;
	
	@Autowired
	public void setBookDao(BookDao bookDao){
		this.bookDao = bookDao;
	}
	
	@Override
	public void create(Book book) {
		bookDao.save(book);
		
	}

	@Override
	public void update(long id, Book book) {
		bookDao.save(book);
		
	}

	@Override
	public void delete(long id) {
		bookDao.delete(id);
		
	}

	@Override
	public List<Book> findByTitleLike(String title) {
		return bookDao.findByTitleLike(title);
	}

	@Override
	public List<Book> findByIsbn(String isbn) {
		return bookDao.findByIsbn(isbn);
	}

	@Override
	public List<Book> findById(long id) {
		return bookDao.findById(id);
	}

	@Override
	public Book get(long id) {
		return bookDao.getOne(id);
	}

	@Override
	public List<Book> getAll() {
		return bookDao.findAll();
	}

}

package cs544.project.onlineshoppingstore.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.project.onlineshoppingstore.dao.BookDao;
import cs544.project.onlineshoppingstore.model.Book;
import cs544.project.onlineshoppingstore.utils.IdToEntityConvertor;

@Transactional(propagation = Propagation.REQUIRED)
@Component
public class BookServiceImpl implements BookService {

	private BookDao bookDao;
	

	@Autowired
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	@Autowired
	private IdToEntityConvertor idToEntityConvertor;

	@Override
	public void create(Book book) {
		try {
			
			byte[] coverBytes = book.getCover().getBytes();
			book.setBookCover(coverBytes);
			
			book.setAuthors(idToEntityConvertor.getAuthorListFromIdList(book.getAuthorIds()));
			book.setPublisher(idToEntityConvertor.getPublisherFromId(book.getPublisherId()));
			
			bookDao.save(book);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(long id, Book book) {
		
		try {
			byte[] coverBytes = book.getCover().getBytes();
			book.setBookCover(coverBytes);
			
			book.setAuthors(idToEntityConvertor.getAuthorListFromIdList(book.getAuthorIds()));
			book.setPublisher(idToEntityConvertor.getPublisherFromId(book.getPublisherId()));
			
			bookDao.save(book);
		} catch (IOException e) {
			e.printStackTrace();
		}

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
		Book book = bookDao.findOne(id);
		book.setPublisherId(book.getPublisher().getId());
		book.setAuthorIds(idToEntityConvertor.getIdListFromAuthorList(book.getAuthors()));
		
		return book;
	}

	@Override
	public List<Book> getAll() {
		
		return bookDao.findAll();
	}

	@Override
	public List<Book> findByFullTextSearch(String searchText) {
		return bookDao.findByFullTextSearch(searchText);
	}

}

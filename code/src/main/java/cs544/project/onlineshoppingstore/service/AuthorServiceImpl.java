package cs544.project.onlineshoppingstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.project.onlineshoppingstore.dao.AuthorDao;
import cs544.project.onlineshoppingstore.model.Author;

@Transactional(propagation= Propagation.REQUIRED)
@Component
public class AuthorServiceImpl implements AuthorService{

	AuthorDao authorDao;
	
	@Autowired
	public void setAuthorDao(AuthorDao authorDao){
		this.authorDao = authorDao;
	}
	
	@Override
	public Author get(long authorID) {
		return authorDao.findOne(authorID);
	}

	@Override
	public List<Author> getAll() {
		return authorDao.findAll();
	}

	@Override
	public void create(Author author) {
		authorDao.save(author);
		
	}

	@Override
	public void update(long id, Author author) {
		authorDao.save(author);		
	}

	@Override
	public void delete(long authorId) {
		authorDao.delete(authorId);
		
	}

	@Override
	public List<Author> findByFirstName(String firstName) {
		return authorDao.findByFirstName(firstName);
	}

	@Override
	public List<Author> findById(long id) {
		return authorDao.findById(id);
	}

	@Override
	public List<Author> findByLastName(String lastName) {
		return authorDao.findByLastName(lastName);
	}

	@Override
	public List<Author> findByTitle(String title) {
		return authorDao.findByTitle(title);		
	}

}

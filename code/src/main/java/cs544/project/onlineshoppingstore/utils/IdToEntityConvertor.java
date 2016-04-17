package cs544.project.onlineshoppingstore.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.project.onlineshoppingstore.dao.AuthorDao;
import cs544.project.onlineshoppingstore.dao.PublisherDao;
import cs544.project.onlineshoppingstore.model.Author;
import cs544.project.onlineshoppingstore.model.Publisher;

@Component
@Transactional(propagation = Propagation.REQUIRED)
public class IdToEntityConvertor {

	@Autowired
	private AuthorDao authorDao;

	@Autowired
	private PublisherDao publisherDao;

	public List<Author> getAuthorListFromIdList(List<Long> idList) {

		List<Author> authors = new ArrayList<>();
		for (Long id : idList) {
			authors.add(authorDao.findOne(id));
		}

		return authors;
	}

	public List<Publisher> getPublisherListFromIdList(List<Long> idList) {

		List<Publisher> publishers = new ArrayList<>();
		for (Long id : idList) {
			publishers.add(publisherDao.findOne(id));
		}

		return publishers;
	}
	
	public Publisher getPublisherFromId(Long id){
		return publisherDao.findOne(id);
	}
	
	public List<Long> getIdListFromAuthorList(List<Author> authors){
		
		List<Long> ids = new ArrayList<>();
		
		for(Author a: authors)
			ids.add(a.getId());
		return ids;
	}
	
	
}

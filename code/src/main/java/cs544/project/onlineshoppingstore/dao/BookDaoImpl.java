package cs544.project.onlineshoppingstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.transaction.annotation.Transactional;

import cs544.project.onlineshoppingstore.model.Book;

public class BookDaoImpl implements BookDaoCustom {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	@Override
	public List<Book> findByFullTextSearch(String searchText) {

		FullTextEntityManager fullTextEntityManager1 = Search.getFullTextEntityManager(em);
		try {
			fullTextEntityManager1.createIndexer().startAndWait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);

		QueryBuilder qb = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Book.class).get();
		org.apache.lucene.search.Query luceneQuery = qb.keyword()
				.onFields("title", "isbn", "authors.firstName", "authors.lastName", "publisher.name")
				.matching(searchText).createQuery();

		// wrap Lucene query in a javax.persistence.Query
		javax.persistence.Query jpaQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, Book.class);

		// execute search
		List<Book> result = jpaQuery.getResultList();

		em.close();

		return result;

	}

}

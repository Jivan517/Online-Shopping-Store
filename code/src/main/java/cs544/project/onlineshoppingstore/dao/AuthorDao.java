package cs544.project.onlineshoppingstore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cs544.project.onlineshoppingstore.model.Author;



public interface AuthorDao extends JpaRepository<Author,Long>{
	
	public final static String FIND_BY_AUTHOR_QUERY = "SELECT a " + 
													   "FROM Author a LEFT JOIN a.books b " +
													   "WHERE b.title LIKE :title";
	
	List<Author> findByFirstName(String firstName);
	
	List<Author> findById(long id); 
	
	List<Author> findByLastName(String lastName);
	
	@Query(FIND_BY_AUTHOR_QUERY)
	List<Author> findByTitle(@Param("title") String title);	
	
}

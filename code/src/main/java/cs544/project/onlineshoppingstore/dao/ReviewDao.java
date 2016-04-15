package cs544.project.onlineshoppingstore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import cs544.project.onlineshoppingstore.model.BookRating;
import cs544.project.onlineshoppingstore.model.Review;

public interface ReviewDao extends JpaRepository<Review,Long>{
	
	List<Review> findByReviewLike(String review);
	
	List<Review> findByRating(BookRating rating); 	
	

}

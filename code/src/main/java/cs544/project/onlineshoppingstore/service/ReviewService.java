package cs544.project.onlineshoppingstore.service;

import java.util.List;

import cs544.project.onlineshoppingstore.model.Author;
import cs544.project.onlineshoppingstore.model.BookRating;
import cs544.project.onlineshoppingstore.model.Review;

public interface ReviewService {
	
	Review get(long reviewId);
	List<Review> getAll();
	void create(Review review);
	void update(long id, Review review);
	void delete(long id);
	
	List<Review> findByReviewLike(String review);
	
	List<Review> findByRating(BookRating rating); 	
	

}

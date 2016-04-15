package cs544.project.onlineshoppingstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.project.onlineshoppingstore.dao.ReviewDao;
import cs544.project.onlineshoppingstore.model.BookRating;
import cs544.project.onlineshoppingstore.model.Review;

@Transactional(propagation= Propagation.REQUIRED)
@Component
public class ReviewServiceImpl implements ReviewService {

	private ReviewDao reviewDao;
	
	@Autowired
	public void setReviewDao(ReviewDao reviewDao){
		this.reviewDao = reviewDao;
	}
	
	@Override
	public Review get(long reviewId) {
		return reviewDao.getOne(reviewId);
	}

	@Override
	public List<Review> getAll() {
		return reviewDao.findAll();
	}

	@Override
	public void create(Review review) {
		reviewDao.save(review);

	}

	@Override
	public void update(long id, Review review) {
		reviewDao.save(review);
	}

	@Override
	public void delete(long id) {
		reviewDao.delete(id);

	}

	@Override
	public List<Review> findByReviewLike(String review) {
		return reviewDao.findByReviewLike(review);
	}

	@Override
	public List<Review> findByRating(BookRating rating) {
		return reviewDao.findByRating(rating);
	}

}

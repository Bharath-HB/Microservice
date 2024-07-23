package com.ust.Review_Service.Service;

import com.ust.Review_Service.Model.Review;
import com.ust.Review_Service.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    public Object addReview(Review review) {
        return reviewRepository.save(review);
    }

    public List<Review> getReviewByMovieId(String movieId) {
        return reviewRepository.findByMovieId(movieId);
    }

    public List<Review> findAll() {
        return reviewRepository.findAll();
    }
}

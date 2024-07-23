package com.ust.Review_Service.Controller;

import com.ust.Review_Service.Model.Review;
import com.ust.Review_Service.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping("/addreview")
    public ResponseEntity<Review> addReview(@RequestBody Review review) {
        Review savedReview = (Review) reviewService.addReview(review);
        return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
    }


    @GetMapping("/movie/review/{movieId}")
    public ResponseEntity<List<Review>> getReviewByMovieId(@PathVariable String movieId) {
        List<Review> reviews = reviewService.getReviewByMovieId(movieId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping("/getAllReviews")
    public ResponseEntity<List<Review>> getAllAppointment() {
        return ResponseEntity.ok(reviewService.findAll());
    }

}

package com.ust.Movie_Service.fegin;

import com.ust.Movie_Service.Client.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "reviewservice" ,url = "http://localhost:9101/review")
public interface ReviewClient {
    @GetMapping("/getAllReviews")
    public List<Review> getAllReviews();

    @GetMapping("/getReview/movie/{movieId}")
    List<Review> findReviewByMovieId(@PathVariable("movieId") String movieId);
}


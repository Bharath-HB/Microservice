package com.ust.Recommend_Service.Service;

import com.ust.Recommend_Service.Client.Review;
import com.ust.Recommend_Service.Feign.ReviewClient;
import com.ust.Recommend_Service.Model.Recommend;
import com.ust.Recommend_Service.Repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RecommendationService {
    @Autowired
    private RecommendationRepository repo;

    @Autowired
    private ReviewClient client;

    public List<Recommend> getRecommendations() {
        return null;
    }

    public  Double getRatingByMovieId(String movieId) {
        return (Double) client.getAllReviews().stream()
                .filter(review -> review.getMovieId().equals(movieId))
                .mapToInt(Review::getRating)
                .average()
                .orElse(0.0f);
    }


    public List<Recommend> getTopRatedMovies() {
        // Fetch all reviews
        List<Review> reviews = client.getAllReviews();

        // Group reviews by movieId and calculate average rating
        Map<String, Double> averageRatingsByMovieId = reviews.stream()
                .collect(Collectors.groupingBy(Review::getMovieId,
                        Collectors.averagingInt(Review::getRating)));

        // Create Recommend objects for each movieId and average rating

        List<Recommend> topRatedMovies = averageRatingsByMovieId.keySet().stream()
                .map(aDouble -> new Recommend(aDouble, getRatingByMovieId(aDouble)))
                .sorted(Comparator.comparing(Recommend::getRating).reversed())
                .toList();
        return topRatedMovies;
    }

//    public  Float getAverageRating(String movieId) {
//        return (float) client.getAllReviews().stream()
//                .filter(review -> review.getMovieId().equals(movieId))
//                .mapToInt(Review::getRating)
//                .average()
//                .orElse(0.0f);
//    }
}

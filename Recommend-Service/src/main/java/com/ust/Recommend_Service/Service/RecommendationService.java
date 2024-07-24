package com.ust.Recommend_Service.Service;

import com.ust.Recommend_Service.Client.Review;
import com.ust.Recommend_Service.Feign.ReviewClient;
import com.ust.Recommend_Service.Model.Recommend;
import com.ust.Recommend_Service.Repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
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

    public  Float getRatingByMovieId(String movieId) {
        return (float) client.getAllReviews().stream()
                .filter(review -> review.getMovieId().equals(movieId))
                .mapToInt(Review::getRating)
                .average()
                .orElse(0.0f);
    }







}

package com.ust.Recommend_Service.Controller;

import com.ust.Recommend_Service.Client.Review;
import com.ust.Recommend_Service.Model.Recommend;
import com.ust.Recommend_Service.Service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recommend")
public class RecommendationController {
    @Autowired
    private RecommendationService service;

    @GetMapping("/rating/{movieId}")
   public ResponseEntity<Double> getRating(@PathVariable String movieId) {
        Double rating = service.getRatingByMovieId(movieId);
        return new ResponseEntity<>(rating, HttpStatus.OK);
    }

    @GetMapping("/top")
    public ResponseEntity<List<Recommend>> getTopRatedMovies() {
        List<Recommend> topRatedMovies = service.getTopRatedMovies();
        return new ResponseEntity<>(topRatedMovies, HttpStatus.OK);
    }
}

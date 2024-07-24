package com.ust.Movie_Service.Service;

import com.ust.Movie_Service.Client.Review;
import com.ust.Movie_Service.Model.Movie;
import com.ust.Movie_Service.Repository.MovieRepository;
import com.ust.Movie_Service.fegin.ReviewClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ReviewClient client;

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie findMovieByMovieId(String movieId) {
        return movieRepository.findById(movieId).orElse(null);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

//    public FullResponse findReviewByMovieId(String movieId) {
//        Movie m=movieRepository.findByMovieId(movieId).orElse(null);
//        List<Review> list=client.findReviewByMovieId(movieId);
//        FullResponse res= new FullResponse();
//        res.setMovieId(m.getMovieId());
//        res.setMovieName(m.getMovieName());
//        res.setMovieDescription(m.getMovieDescription());
//        res.setMovieGenre(m.getMovieGenre());
//        res.setReleaseDate(m.getReleaseDate());
//        res.setReview(list);
//        return res;
  //      return null;
   // }

    public List<Review> getReviewsByMovieId(String movieId) {
        return client.getAllReviews().stream().filter(e-> e.getMovieId().equals(movieId)).toList();
    }


}

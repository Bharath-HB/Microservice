package com.ust.Movie_Service.Service;

import com.ust.Movie_Service.Model.Movie;
import com.ust.Movie_Service.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;


    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie findMovieByMovieId(String movieId) {
        return movieRepository.findById(movieId).orElse(null);
    }
}

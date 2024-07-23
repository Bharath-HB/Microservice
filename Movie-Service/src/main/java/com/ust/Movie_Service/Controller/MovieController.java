package com.ust.Movie_Service.Controller;

import com.ust.Movie_Service.Model.Movie;
import com.ust.Movie_Service.Service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping("/addmovie")
    public Movie addMovie(@RequestBody Movie movie){
        return movieService.addMovie(movie);
    }

    @GetMapping("/search/{movieId}")
    public ResponseEntity<Movie> findMovieByMovieId(@PathVariable ("movieId") String movieId){
        return ResponseEntity.ok(movieService.findMovieByMovieId(movieId));
    }
}

package com.ust.Movie_Service.Repository;

import com.ust.Movie_Service.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie,String> {
    Optional<Movie> findByMovieId(String movieId);
}

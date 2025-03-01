package com.ust.Review_Service.Repository;

import com.ust.Review_Service.Model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,String> {

    List<Review> findByMovieId(String movieId);

    List<Review> findByUserId(String userId);
}

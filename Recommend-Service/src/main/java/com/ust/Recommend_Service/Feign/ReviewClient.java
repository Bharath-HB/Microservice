package com.ust.Recommend_Service.Feign;

import com.ust.Recommend_Service.Client.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "reviewservice" ,url = "http://localhost:9101/review")
public interface ReviewClient {
    @GetMapping("/getAllReviews")
    public List<Review> getAllReviews();
}

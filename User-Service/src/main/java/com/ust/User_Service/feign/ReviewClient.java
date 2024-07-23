package com.ust.User_Service.feign;

import com.ust.User_Service.Client.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "reviewservice" ,url = "http://localhost:9101/review")
public interface ReviewClient {
    @PostMapping("/addReview")
    public Review addReview(@RequestBody Review review);
}


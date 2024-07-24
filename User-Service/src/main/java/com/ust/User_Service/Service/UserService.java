package com.ust.User_Service.Service;


import com.ust.User_Service.Client.Review;
import com.ust.User_Service.Model.User;
import com.ust.User_Service.Repository.UserRepository;
import com.ust.User_Service.feign.ReviewClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReviewClient reviewClient;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(String userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<Review> getReviewsByUserId(String userId) {
        return reviewClient.getAllReviews().stream()
                .filter(review -> review.getUserId().equals(userId))
                .toList();
    }

}

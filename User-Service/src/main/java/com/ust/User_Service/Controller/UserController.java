package com.ust.User_Service.Controller;


import com.ust.User_Service.Client.Review;
import com.ust.User_Service.Model.User;
import com.ust.User_Service.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<User> addPatient(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @GetMapping("/getUserById/{userId}")
    public ResponseEntity<User> getUserById(@RequestParam String userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/getReviews/{userId}")
    public ResponseEntity<List<Review>> getReviewsByUserId(String userId) {
        List<Review> reviews=userService.getReviewsByUserId(userId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }


}

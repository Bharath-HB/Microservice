package com.ust.User_Service.Client;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class Review {
    private String reviewId;
    private String userId;
    private String movieId;
    private String feedback;
    private int rating;
}
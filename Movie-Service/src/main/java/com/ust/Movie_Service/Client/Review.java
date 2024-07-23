package com.ust.Movie_Service.Client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Review {
    private String userid;
    private String username;
    private String reviewText;
    private int rating;
    private String movieId;
}
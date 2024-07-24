package com.ust.Recommend_Service.Client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Review {
    private String reviewId;
    private String userId;
    private String movieId;
    private String feedback;
    private int rating;
}

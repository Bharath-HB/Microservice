package com.ust.Movie_Service.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "movie_info")
public class Movie {
    @Id
    public String movieId; //pk,fk
    public String movieName;
    public String movieDescription;
    public String movieGenre;
    public String releaseDate;
}
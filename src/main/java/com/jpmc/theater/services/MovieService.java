package com.jpmc.theater.services;

import com.jpmc.theater.models.Customer;
import com.jpmc.theater.models.Movie;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

/*
 Singleton class that handles all the operations regarding movies
 */
public class MovieService {

    private static MovieService instance;
    private ArrayList<Movie> movies;

    public static MovieService getInstance(){
        if (instance == null){
            instance = new MovieService();
        }

        return instance;
    }

    private MovieService(){
        // Typically populate from database here.
        this.movies = new ArrayList<Movie>(
                Arrays.asList(
                        new Movie(UUID.randomUUID().toString(),"Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1),
                        new Movie(UUID.randomUUID().toString(),"Turning Red", Duration.ofMinutes(85), 11, 0),
                        new Movie(UUID.randomUUID().toString(),"The Batman", Duration.ofMinutes(95), 9, 0)
                )
        );
    }

    public ArrayList<Movie> GetMovies(){
        return this.movies;
    }
}

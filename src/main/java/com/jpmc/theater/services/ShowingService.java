package com.jpmc.theater.services;

import com.jpmc.theater.models.Movie;
import com.jpmc.theater.models.Showing;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

/*
 Singleton class that handles all the operations regarding all the showings
 */
public class ShowingService {
    private static ShowingService instance;
    private ArrayList<Showing> showings;
    private MovieService movieService;

    private static ShowingService getInstance(){
        if (instance == null){
            instance = new ShowingService();
        }

        return instance;
    }

    private ShowingService(){
        this.movieService = MovieService.getInstance();

        // Typically populate from database here.
        ArrayList<Movie> movies = this.movieService.GetMovies();
        this.showings = new ArrayList<Showing>(
                Arrays.asList(
                        new Showing(movies.get(2), 1, LocalDateTime.of(provider.currentDate(), LocalTime.of(9, 0))),
                        new Showing(movies.get(1), 2, LocalDateTime.of(provider.currentDate(), LocalTime.of(11, 0))),
                        new Showing(movies.get(3), 3, LocalDateTime.of(provider.currentDate(), LocalTime.of(12, 50))),
                        new Showing(movies.get(2), 4, LocalDateTime.of(provider.currentDate(), LocalTime.of(14, 30))),
                        new Showing(movies.get(1), 5, LocalDateTime.of(provider.currentDate(), LocalTime.of(16, 10))),
                        new Showing(movies.get(3), 6, LocalDateTime.of(provider.currentDate(), LocalTime.of(17, 50))),
                        new Showing(movies.get(2), 7, LocalDateTime.of(provider.currentDate(), LocalTime.of(19, 30))),
                        new Showing(movies.get(1), 8, LocalDateTime.of(provider.currentDate(), LocalTime.of(21, 10))),
                        new Showing(movies.get(3), 9, LocalDateTime.of(provider.currentDate(), LocalTime.of(23, 0)))
                )
        );
    }

    public ArrayList<Showing> GetShowings(){
        return this.showings;
    }
}

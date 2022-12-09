package com.jpmc.theater.models.discounts;

import com.jpmc.theater.models.Movie;
import com.jpmc.theater.models.Showing;

public class SpecialMovieDiscount implements Discount{

    private static int MOVIE_CODE_SPECIAL = 1;

    @Override
    public boolean isDiscountApplicable(Movie movie, Showing showing) {
        return MOVIE_CODE_SPECIAL == movie.getSpecialCode();
    }

    @Override
    public double calculateDiscount(Movie movie) {
        return movie.getTicketPrice() * 0.2;
    }
}

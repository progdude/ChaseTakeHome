package com.jpmc.theater.models.discounts;

import com.jpmc.theater.models.Movie;
import com.jpmc.theater.models.Showing;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class ElevenToFourDiscount implements Discount {

    @Override
    public boolean isDiscountApplicable(Movie movie, Showing showing) {
        LocalDateTime elevenAM = LocalDateTime.of(showing.getStartTime().toLocalDate(), LocalTime.of(11, 0));
        LocalDateTime fourPM = LocalDateTime.of(showing.getStartTime().toLocalDate(), LocalTime.of(16, 0));
        return !(showing.getStartTime().isBefore(elevenAM) || showing.getStartTime().isAfter(fourPM));
    }

    @Override
    public double calculateDiscount(Movie movie) {
        return movie.getTicketPrice() * 0.25;
    }
}
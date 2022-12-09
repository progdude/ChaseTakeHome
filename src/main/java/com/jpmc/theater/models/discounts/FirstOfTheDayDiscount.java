package com.jpmc.theater.models.discounts;

import com.jpmc.theater.models.Movie;
import com.jpmc.theater.models.Showing;

public class FirstOfTheDayDiscount implements Discount {
    @Override
    public boolean isDiscountApplicable(Movie movie, Showing showing) {
        return showing.getSequenceOfTheDay() == 1;
    }

    @Override
    public double calculateDiscount(Movie movie) {
        return 3;
    }
}
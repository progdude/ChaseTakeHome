package com.jpmc.theater.models.discounts;

import com.jpmc.theater.models.Movie;
import com.jpmc.theater.models.Showing;

public class SeventhOfTheMonthDiscount implements Discount{
    @Override
    public boolean isDiscountApplicable(Movie movie, Showing showing) {
        return showing.getStartTime().getDayOfMonth() == 7;
    }

    @Override
    public double calculateDiscount(Movie movie) {
        return 1;
    }
}

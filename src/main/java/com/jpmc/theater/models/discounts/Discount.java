package com.jpmc.theater.models.discounts;

import com.jpmc.theater.models.Movie;
import com.jpmc.theater.models.Showing;

public interface Discount {

    public boolean isDiscountApplicable(Movie movie, Showing showing);

    public double calculateDiscount(Movie movie);
}

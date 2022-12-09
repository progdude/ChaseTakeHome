package com.jpmc.theater.services;

import com.jpmc.theater.models.Movie;
import com.jpmc.theater.models.Showing;
import com.jpmc.theater.models.discounts.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

/*
 Singleton class that handles all the operations regarding discounts
 */
public class DiscountService {

    private static DiscountService instance;
    private ArrayList<Discount> discounts;

    public static DiscountService getInstance(){
        if (instance == null){
            instance = new DiscountService();
        }

        return instance;
    }

    private DiscountService(){
        // Typically populate from database here.
        this.discounts = new ArrayList<Discount>(
                Arrays.asList(
                        new ElevenToFourDiscount(),
                        new FirstOfTheDayDiscount(),
                        new SecondOfTheDayDiscount(),
                        new SecondOfTheDayDiscount(),
                        new SpecialMovieDiscount()
                )
        );
    }

    public double calculateMoviePrice(Movie movie, Showing showing){

        double maxPrice = 0;
        for(Discount discount: this.discounts){
            if (discount.isDiscountApplicable(movie, showing)){
                maxPrice = Math.max(maxPrice, discount.calculateDiscount(movie));
            }
        }

        return maxPrice;
    }
}

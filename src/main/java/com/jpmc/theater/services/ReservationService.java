package com.jpmc.theater.services;

import com.jpmc.theater.models.Customer;
import com.jpmc.theater.models.Movie;
import com.jpmc.theater.models.Reservation;
import com.jpmc.theater.models.Showing;

import java.util.ArrayList;

/*
 Singleton class that handles all the operations regarding reservations
 */
public class ReservationService {
    private static ReservationService instance;
    private ArrayList<Reservation> reservations;

    private DiscountService discountService;

    private double cost;

    public static ReservationService getInstance(){
        if (instance == null){
            instance = new ReservationService();
        }

        return instance;
    }

    private ReservationService(){
        // Typically populate from database here.
        this.reservations = new ArrayList<Reservation>();
        this.discountService = DiscountService.getInstance();
        this.cost = 0;
    }

    public void reserve(Reservation reservation){
        this.cost = this.calculateTicketPrice(reservation) * reservation.getAudienceCount();
    }

    public ArrayList<Reservation> getReservations(){
        return this.reservations;
    }

    private double calculateTicketPrice(Reservation reservation){
        return this.discountService.calculateMoviePrice(reservation.getShowing().getMovie(), reservation.getShowing());
    }
}

package com.jpmc.theater.services;

import com.jpmc.theater.models.Movie;
import com.jpmc.theater.models.Reservation;

import java.util.ArrayList;

/*
 Singleton class that handles all the operations regarding reservations
 */
public class ReservationService {
    private static ReservationService instance;
    private ArrayList<Reservation> reservations;

    private DiscountService discountService;

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
    }

    public ArrayList<Reservation> GetReservations(){
        return this.reservations;
    }

    public double calculateTicketPrice(Reservation reservation){
        return this.discountService.calculateMoviePrice(reservation.getShowing().getMovie(), reservation.getShowing());
    }
}

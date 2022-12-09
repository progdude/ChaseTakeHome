package com.jpmc.theater;

import com.jpmc.theater.models.Customer;
import com.jpmc.theater.models.Reservation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TheaterTests {
    @Test
    void totalFeeForCustomer() {
        Theater theater = new Theater();
        Customer john = new Customer("John Doe", "id-12345");
        Reservation reservation = theater.reserve(john, 1, 4);
        assertEquals(reservation.totalFee(), 32);
    }

    @Test
    void printMovieScheduleSimpleText() {
        Theater theater = new Theater();
        theater.printSimpleText();
    }

    @Test
    void printMovieScheduleJSON() {
        Theater theater = new Theater();
        theater.printJson();
    }
}

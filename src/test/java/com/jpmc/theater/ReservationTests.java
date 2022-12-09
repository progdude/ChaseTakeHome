package com.jpmc.theater;

import com.jpmc.theater.models.Customer;
import com.jpmc.theater.models.Movie;
import com.jpmc.theater.models.Reservation;
import com.jpmc.theater.models.Showing;
import com.jpmc.theater.services.ReservationService;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReservationTests {

    @Test
    void totalFee() {
        var customer = new Customer("John Doe", "unused-id");
        var showing = new Showing(
                new Movie(UUID.randomUUID().toString(), "Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 0),
                4,
                LocalDateTime.of(LocalDate.of(2022, 12, 10), LocalTime.of(10,0))
        );

        Reservation r = new Reservation(customer, showing, 3);
        ReservationService.getInstance().reserve(r);
        assertEquals(r.totalFee(), 37.5, 0.01);
    }

    @Test
    void EleventToFourDiscountTest() {
        var customer = new Customer("John Doe", "unused-id");
        var showing = new Showing(
                new Movie(UUID.randomUUID().toString(), "Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 0),
                4,
                LocalDateTime.of(LocalDate.of(2022, 12, 10), LocalTime.of(12,0))
        );

        Reservation r = new Reservation(customer, showing, 3);
        ReservationService.getInstance().reserve(r);
        assertEquals(r.totalFee(), 28.12, 0.01);
    }

    @Test
    void FirstOfTheDayDiscountTest() {
        var customer = new Customer("John Doe", "unused-id");
        var showing = new Showing(
                new Movie(UUID.randomUUID().toString(), "Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 0),
                1,
                LocalDateTime.of(LocalDate.of(2022, 12, 10), LocalTime.of(10,0))
        );

        Reservation r = new Reservation(customer, showing, 3);
        ReservationService.getInstance().reserve(r);
        assertEquals(r.totalFee(), 28.5, 0.01);
    }

    @Test
    void SecondOfTheDayDiscountTest() {
        var customer = new Customer("John Doe", "unused-id");
        var showing = new Showing(
                new Movie(UUID.randomUUID().toString(), "Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 0),
                2,
                LocalDateTime.of(LocalDate.of(2022, 12, 10), LocalTime.of(10,0))
        );

        Reservation r = new Reservation(customer, showing, 3);
        ReservationService.getInstance().reserve(r);
        assertEquals(r.totalFee(), 31.5, 0.01);
    }

    @Test
    void SeventhOfTheMonthDiscountTest() {
        var customer = new Customer("John Doe", "unused-id");
        var showing = new Showing(
                new Movie(UUID.randomUUID().toString(), "Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 0),
                4,
                LocalDateTime.of(LocalDate.of(2022, 12, 07), LocalTime.of(10,0))
        );

        Reservation r = new Reservation(customer, showing, 3);
        ReservationService.getInstance().reserve(r);
        assertEquals(r.totalFee(), 34.5, 0.01);
    }

    @Test
    void SpecialMovieDiscountTest() {
        var customer = new Customer("John Doe", "unused-id");
        var showing = new Showing(
                new Movie(UUID.randomUUID().toString(), "Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1),
                4,
                LocalDateTime.of(LocalDate.of(2022, 12, 10), LocalTime.of(10,0))
        );

        Reservation r = new Reservation(customer, showing, 3);
        ReservationService.getInstance().reserve(r);
        assertEquals(r.totalFee(), 30, 0.01);
    }
}

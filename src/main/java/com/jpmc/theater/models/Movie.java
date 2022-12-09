package com.jpmc.theater.models;

import java.time.Duration;
import java.util.Objects;

/**
 * Class to represent the Customer Object
 */
public class Movie {

    private String id;
    private String title;
    private String description;
    private Duration runningTime;
    private double ticketPrice;
    private int specialCode;

    public Movie(String id, String title, Duration runningTime, double ticketPrice, int specialCode) {
        this.id = id;
        this.title = title;
        this.runningTime = runningTime;
        this.ticketPrice = ticketPrice;
        this.specialCode = specialCode;
    }

    public String getTitle() {
        return this.title;
    }

    public Duration getRunningTime() {
        return this.runningTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public int getSpecialCode() {
        return specialCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Double.compare(movie.ticketPrice, ticketPrice) == 0 &&
                Objects.equals(title, movie.title) &&
                Objects.equals(description, movie.description) &&
                Objects.equals(runningTime, movie.runningTime) &&
                Objects.equals(specialCode, movie.specialCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, runningTime, ticketPrice, specialCode);
    }
}
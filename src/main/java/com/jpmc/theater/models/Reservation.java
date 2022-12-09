package com.jpmc.theater.models;

public class Reservation {
    private Customer customer;
    private Showing showing;
    private int audienceCount;
    private double cost;

    public Reservation(Customer customer, Showing showing, int audienceCount) {
        this.customer = customer;
        this.showing = showing;
        this.audienceCount = audienceCount;
        this.cost = showing.getMovieFee() * audienceCount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Showing getShowing() {
        return showing;
    }

    public int getAudienceCount() {
        return audienceCount;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double totalFee() {
        return this.cost;
    }
}

package com.jpmc.theater.services;

import com.jpmc.theater.models.Customer;

import java.util.ArrayList;

/*
 Singleton class that handles all the operations regarding the customer
 */
public class CustomerService {

    private static CustomerService instance;
    private ArrayList<Customer> customers;

    public static CustomerService getInstance(){
        if (instance == null){
            instance = new CustomerService();
        }

        return instance;
    }

    private CustomerService(){
        // Typically populate from database here.
        this.customers = new ArrayList<Customer>();
    }
}

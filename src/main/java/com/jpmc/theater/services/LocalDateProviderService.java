package com.jpmc.theater.services;

import java.time.LocalDate;

public class LocalDateProviderService {

    private static LocalDateProviderService instance;

    public static LocalDateProviderService getInstance(){
        if (instance == null){
            instance = new LocalDateProviderService();
        }

        return instance;
    }

    public LocalDate currentDate() {
        return LocalDate.now();
    }
}

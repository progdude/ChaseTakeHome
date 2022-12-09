package com.jpmc.theater.services.printing;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jpmc.theater.models.Showing;
import com.jpmc.theater.services.*;
import com.jpmc.theater.util.DurationDeserializer;
import com.jpmc.theater.util.DurationSerializer;
import com.jpmc.theater.util.LocalDateTimeSerializer;

import java.time.Duration;
import java.time.LocalDateTime;

public class JsonPrintingService {

    private static JsonPrintingService instance;
    private Gson gson;
    private ShowingService showingService;

    public static JsonPrintingService getInstance(){
        if (instance == null){
            instance = new JsonPrintingService();
        }

        return instance;
    }

    private JsonPrintingService(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Duration.class, new DurationSerializer());
        gsonBuilder.registerTypeAdapter(Duration.class, new DurationDeserializer());
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
        this.gson = gsonBuilder.setPrettyPrinting().create();
        this.showingService = ShowingService.getInstance();
    }

    public void printSchedule() {
        System.out.println(LocalDateProviderService.getInstance().currentDate());
        System.out.println("JSON");
        System.out.println("===================================================");
        System.out.println(this.gson.toJson(showingService.GetShowings()));
        System.out.println("===================================================");
    }
}

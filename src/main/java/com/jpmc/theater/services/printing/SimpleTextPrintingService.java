package com.jpmc.theater.services.printing;

import com.jpmc.theater.models.Showing;
import com.jpmc.theater.services.LocalDateProviderService;
import com.jpmc.theater.services.ShowingService;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SimpleTextPrintingService implements PrintingService {

    private static SimpleTextPrintingService instance;
    private ShowingService showingService;

    public static SimpleTextPrintingService getInstance(){
        if (instance == null){
            instance = new SimpleTextPrintingService();
        }

        return instance;
    }

    private SimpleTextPrintingService(){
        this.showingService = ShowingService.getInstance();
    }

    public void printSchedule() {
        ArrayList<Showing> schedule = this.showingService.GetShowings();
        System.out.println(LocalDateProviderService.getInstance().currentDate());
        System.out.println("===================================================");
        schedule.forEach(s ->
                System.out.println(s.getSequenceOfTheDay() + ": " + s.getStartTime() + " " + s.getMovie().getTitle() + " " + humanReadableFormat(s.getMovie().getRunningTime()) + " $" + s.getMovieFee())
        );
        System.out.println("===================================================");
    }

    public String humanReadableFormat(Duration duration) {
        long hour = duration.toHours();
        long remainingMin = duration.toMinutes() - TimeUnit.HOURS.toMinutes(duration.toHours());

        return String.format("(%s hour%s %s minute%s)", hour, handlePlural(hour), remainingMin, handlePlural(remainingMin));
    }

    // (s) postfix should be added to handle plural correctly
    private String handlePlural(long value) {
        if (value == 1) {
            return "";
        }
        else {
            return "s";
        }
    }
}

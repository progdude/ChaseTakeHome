package com.jpmc.theater;

import com.jpmc.theater.models.Customer;
import com.jpmc.theater.models.Movie;
import com.jpmc.theater.models.Reservation;
import com.jpmc.theater.models.Showing;
import com.jpmc.theater.services.*;
import com.jpmc.theater.services.printing.JsonPrintingService;
import com.jpmc.theater.services.printing.PrintingService;
import com.jpmc.theater.services.printing.SimpleTextPrintingService;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Theater {

    private ReservationService reservationService;
    private ShowingService showingService;
    private CustomerService customerService;
    private MovieService movieService;
    private LocalDateProviderService localDateProviderService;
    private JsonPrintingService jsonPrintingService;
    private SimpleTextPrintingService simpleTextPrintingService;

    public Theater() {
        this.reservationService = ReservationService.getInstance();
        this.showingService = ShowingService.getInstance();
        this.customerService = CustomerService.getInstance();
        this.movieService = MovieService.getInstance();
        this.localDateProviderService = LocalDateProviderService.getInstance();
        this.jsonPrintingService = JsonPrintingService.getInstance();
        this.simpleTextPrintingService = SimpleTextPrintingService.getInstance();
    }

    public Reservation reserve(Customer customer, int sequence, int ticketAmount) {
        Showing showing;
        Reservation reservation;
        try {
            showing = this.showingService.GetShowings().get(sequence-1);
            reservation = new Reservation(customer, showing, ticketAmount);
            this.reservationService.reserve(reservation);
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            throw new IllegalStateException("not able to find any showing for given sequence " + sequence);
        }
        return reservation;
    }

    public void printJson(){
        this.jsonPrintingService.printSchedule();
    }

    public void printSimpleText(){
        this.simpleTextPrintingService.printSchedule();
    }

    public static void main(String[] args) {
        Theater theater = new Theater();
        theater.printSimpleText();
        theater.printJson();
    }
}

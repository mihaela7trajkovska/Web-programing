package mk.finki.ukim.mk.labb.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Data
public class Event {

    private Long id;
    private String name;
    private String description;
    private double popularityScore;
    private Location location;

    public Event(String name, String description, double popularityScore,Location location) {
        this.id = (long)(Math.random()*1000);
        this.name = name;
        this.description = description;
        this.popularityScore = popularityScore;
        this.location=location;
    }

    private List<EventBooking> bookings = new ArrayList<>();



    public void addBooking(EventBooking booking) {
        this.bookings.add(booking);
    }
}

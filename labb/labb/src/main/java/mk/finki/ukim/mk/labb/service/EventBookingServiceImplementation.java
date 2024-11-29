package mk.finki.ukim.mk.labb.service;

import mk.finki.ukim.mk.labb.model.Event;
import mk.finki.ukim.mk.labb.model.EventBooking;
import org.springframework.stereotype.Service;

@Service
public class EventBookingServiceImplementation implements EventBookingService {

    @Override
    public EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, int numTickets) {
        return new EventBooking(eventName, attendeeName, attendeeAddress, (long) numTickets);
    }

    @Override
    public EventBooking bookEvent(Event event, String attendeeName, int numTickets) {

        EventBooking booking = new EventBooking(event.getName(), attendeeName, "", (long) numTickets);
        event.addBooking(booking);
        return booking;
    }
}
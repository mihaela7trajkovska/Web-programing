package mk.finki.ukim.mk.labb.service;

import mk.finki.ukim.mk.labb.model.Event;
import mk.finki.ukim.mk.labb.model.EventBooking;

public interface EventBookingService {
    EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, int numTickets);
    EventBooking bookEvent(Event event, String attendeeName, int numTickets);
}

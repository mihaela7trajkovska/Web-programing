package mk.finki.ukim.mk.labb.web.controller;


import mk.finki.ukim.mk.labb.bootstrap.DataHolder;
import mk.finki.ukim.mk.labb.model.Event;
import mk.finki.ukim.mk.labb.model.EventBooking;
import mk.finki.ukim.mk.labb.service.EventBookingService;
import mk.finki.ukim.mk.labb.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/bookings")
public class EventBookingController {

    private final EventBookingService eventBookingService;
    private final EventService eventService;

    public EventBookingController(EventBookingService eventBookingService, EventService eventService) {
        this.eventBookingService = eventBookingService;
        this.eventService = eventService;
    }


    @GetMapping("/book/{eventId}")
    public String showBookingForm(@PathVariable Long eventId, Model model) {
        Event event = DataHolder.events.stream()
                .filter(e -> e.getId().equals(eventId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid event ID"));
        model.addAttribute("event", event);
        return "booking-form";
    }


    @PostMapping("/book/{eventId}")
    public String bookEvent(@PathVariable Long eventId,
                            @RequestParam String attendeeName,
                            @RequestParam int numTickets,
                            Model model) {
        Event event = DataHolder.events.stream()
                .filter(e -> e.getId().equals(eventId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid event ID"));


        EventBooking booking = eventBookingService.bookEvent(event, attendeeName, numTickets);

        //String clientIpAddress = request.getRemoteAddr();


        model.addAttribute("attendeeName", attendeeName);
        //model.addAttribute("ipAddress", clientIpAddress);
        model.addAttribute("eventName", event.getName());
        model.addAttribute("numTickets", numTickets);

        return "booking-confirmation";
    }
}

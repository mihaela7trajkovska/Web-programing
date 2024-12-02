package mk.finki.ukim.mk.labb.web.controller;

import org.springframework.ui.Model;
import mk.finki.ukim.mk.labb.model.Event;
import mk.finki.ukim.mk.labb.service.EventService;
import mk.finki.ukim.mk.labb.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Controller
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;
    private final LocationService locationService;

    public EventController(EventService eventService, LocationService locationService) {
        this.eventService = eventService;
        this.locationService = locationService;
    }

    @GetMapping
    public String getEventsPage(@RequestParam(required = false) String error, Model model) {
        List<Event> events = eventService.listAll();
        model.addAttribute("events", events);
        model.addAttribute("error", error);
        return "listEvents";
    }

    @GetMapping("/form")
    public String getEventForm(@RequestParam(required = false) Long id, Model model) {
        if (id != null) {
            Optional<Event> event = eventService.findById(id);
            if (event.isPresent()) {
                model.addAttribute("event", event.get());
            } else {
                model.addAttribute("error", "Event not found");
                return "redirect:/events";
            }
        }
        model.addAttribute("locations", locationService.findAll());
        return "add-event";
    }

    @PostMapping("/save")
    public String saveOrUpdateEvent(
            @RequestParam(required = false) Long id,
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam double popularityScore,
            @RequestParam Long locationId) {
        if (id != null) {
            eventService.edit(id, name, description, popularityScore, locationId);
        } else {
            eventService.save(name, description, popularityScore, locationId);
        }
        return "redirect:/events";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventService.delete(id);
        return "redirect:/events";
    }
}



/*@Controller
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;
    private final LocationService locationService;

    public EventController(EventService eventService, LocationService locationService) {
        this.eventService = eventService;
        this.locationService = locationService;
    }

    @GetMapping
    public String getEventsPage(@RequestParam(required = false) String error, Model model) {
       // model.addAttribute("events", eventService.listAll());
       // model.addAttribute("error", error);
        List<Event> events = eventService.listAll();
        model.addAttribute("events", events);
        return "listEvents";
    }

    @GetMapping("/add-form")
    public String getAddEventPage(Model model) {

        model.addAttribute("locations", locationService.findAll());
        return "add-event";
    }

    @PostMapping("/save")
    public String saveEvent(@RequestParam String name, @RequestParam String description,
                            @RequestParam double popularityScore, @RequestParam Long locationId) {
        eventService.save(name, description, popularityScore, locationId);
        return "redirect:/events";
    }

    @GetMapping("/edit-form/{id}")
    public String getEditEventForm(@PathVariable Long id, Model model) {
        Optional<Event> event = eventService.findById(id);
        if (event.isPresent()) {
            model.addAttribute("event", event.get());
            model.addAttribute("locations", locationService.findAll());
            return "add-event";
        } else {
            model.addAttribute("error", "Event not found");
            return "redirect:/events";
        }
    }

    @PostMapping("/edit/{id}")
    public String editEvent(@PathVariable Long id, @RequestParam String name,
                            @RequestParam String description, @RequestParam double popularityScore,
                            @RequestParam Long locationId) {
        eventService.edit(id, name, description, popularityScore, locationId);
        return "redirect:/events";
    }

    @PostMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventService.delete(id);
        return "redirect:/events";
    }
}*/

package mk.finki.ukim.mk.labb.service;

import mk.finki.ukim.mk.labb.model.Event;
import mk.finki.ukim.mk.labb.model.Location;
import mk.finki.ukim.mk.labb.repository.EventRepository;
import mk.finki.ukim.mk.labb.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImplementation implements EventService {
    private final EventRepository eventRepository;
    private final LocationRepository locationRepository;

    public EventServiceImplementation(EventRepository eventRepository, LocationRepository locationRepository) {

        this.eventRepository = eventRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Event> listAll() {
        return eventRepository.findAll();
    }

  /* @Override
    public List<Event> searchEvents(String text) {
        return eventRepository.searchEvents(text);
    }*/

    @Override
    public Optional<Event> findById(Long id) {
        return this.eventRepository.findById(id);
    }

    @Override
    public Optional<Event> edit(Long id, String name, String description, double popularityScore, Long locationId) {

        Optional<Event> optionalEvent = eventRepository.findById(id);
        if (optionalEvent.isEmpty()) {
            return Optional.empty();
        }


        if (name == null || name.isEmpty() || description == null || description.isEmpty() || locationId == null) {
            return Optional.empty();
        }


        Optional<Location> optionalLocation = locationRepository.findById(locationId);
        if (optionalLocation.isEmpty()) {
            return Optional.empty();
        }


        Event event = optionalEvent.get();
        event.setName(name);
        event.setDescription(description);
        event.setPopularityScore(popularityScore);
        event.setLocation(optionalLocation.get());

        eventRepository.save(event);


        return Optional.of(event);
    }


    @Override
    public void delete(Long id) {
        this.eventRepository.delete(id);

    }

    @Override
    public Optional<Event> save(String name, String description, double popularityScore, Long locationId) {

        Optional<Location> location = locationRepository.findById(locationId);
        if (location.isPresent()) {
            Event newEvent = new Event(name, description, popularityScore, location.get());
            eventRepository.save(newEvent);
            return Optional.of(newEvent);
        }
        return Optional.empty();
    }



}


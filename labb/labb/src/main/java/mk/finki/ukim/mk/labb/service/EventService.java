package mk.finki.ukim.mk.labb.service;


import mk.finki.ukim.mk.labb.model.Event;

import java.util.List;
import java.util.Optional;


public interface EventService {
    List<Event> listAll();
    // List<Event> searchEvents(String text);

    Optional<Event> findById(Long id);

    Optional<Event> edit(Long id, String name, String description, double popularityScore, Long locationId);

    void delete(Long id);

    Optional<Event> save(String name, String description, double popularityScore, Long locationId);

    List<Event> findAllByLocation_Id(Long locationId);
}

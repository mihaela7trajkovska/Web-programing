package mk.finki.ukim.mk.labb.repository;

import mk.finki.ukim.mk.labb.bootstrap.DataHolder;
import mk.finki.ukim.mk.labb.model.Event;
import mk.finki.ukim.mk.labb.model.Location;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EventRepository {


    public List<Event> findAll() {
        return DataHolder.events;
    }

    public Optional<Event> findById(Long id) {
        return DataHolder.events.stream().filter(event -> event.getId().equals(id)).findFirst();
    }

    public Optional<Event> delete(Long id) {
        Optional<Event> event = findById(id);
        event.ifPresent(DataHolder.events::remove);
        return event;
    }

    public Optional<Event> edit(Long id, String name, String description, double popularityScore, Location location) {
        Optional<Event> event = findById(id);
        event.ifPresent(e -> {
            e.setName(name);
            e.setDescription(description);
            e.setPopularityScore(popularityScore);
            e.setLocation(location);
        });
        return event;
    }

    public void save(Event event) {
        DataHolder.events.add(event);
    }

}

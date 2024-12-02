package mk.finki.ukim.mk.labb.repository.jpa;

import mk.finki.ukim.mk.labb.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface
EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAllByLocation_Id(Long locationId);

}

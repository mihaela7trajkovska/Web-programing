package mk.finki.ukim.mk.labb.repository;

import mk.finki.ukim.mk.labb.bootstrap.DataHolder;
import mk.finki.ukim.mk.labb.model.Location;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static mk.finki.ukim.mk.labb.bootstrap.DataHolder.locations;

@Repository
public class LocationRepository {


    public List<Location> findAll() {
        return DataHolder.locations;
    }

    public Optional<Location> findById(Long locationId) {
        return locations.stream()
                .filter(location -> location.getId().equals(locationId))
                .findFirst();
    }
}


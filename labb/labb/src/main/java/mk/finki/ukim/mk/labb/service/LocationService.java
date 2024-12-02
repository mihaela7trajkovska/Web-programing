package mk.finki.ukim.mk.labb.service;

import mk.finki.ukim.mk.labb.model.Location;

import java.util.List;
import java.util.Optional;

public interface LocationService {
    List<Location> findAll();
    public Optional<Location> findByID(long id);
}

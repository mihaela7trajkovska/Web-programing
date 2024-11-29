package mk.finki.ukim.mk.labb.service;

import mk.finki.ukim.mk.labb.model.Location;
import mk.finki.ukim.mk.labb.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRep;

    public LocationServiceImpl(LocationRepository locationRep) {
        this.locationRep = locationRep;
    }

    @Override
    public List<Location> findAll() {
        return locationRep.findAll();
    }
}

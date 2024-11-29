package mk.finki.ukim.mk.labb.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.labb.model.Event;
import mk.finki.ukim.mk.labb.model.Location;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Event> events = new ArrayList<>();
    public static List<Location> locations = new ArrayList<>();
    @PostConstruct
    public void init() {

        locations.add(new Location(1L, "Ohrid Amphitheater", "Ohrid", "2000", "Outdoor amphitheater in Ohrid"));
        locations.add(new Location(2L, "Tikves Winery", "Kavadarci", "500", "Winery in Kavadarci"));
        locations.add(new Location(3L, "Strumica Carnival Square", "Strumica", "1500", "Main square in Strumica"));
        locations.add(new Location(4L, "Skopje Marathon Track", "Skopje", "5000", "Marathon route in Skopje"));
        locations.add(new Location(5L, "Dojran Beach", "Dojran", "3000", "Beach in Dojran for music festival"));


        events.add(new Event("Ohridsko Leto", "Kulturn i muzicki festival vo Ohrid", 9.5, locations.get(0)));
        events.add(new Event("Tikveski Grozdober", "Festival na vino i grozje vo Kavadarci", 8.8, locations.get(1)));
        events.add(new Event("Strumicki Karneval", "Tradicionalen karneval so maski vo Strumica", 9.2, locations.get(2)));
        events.add(new Event("Skopski Maraton", "Godishen sportski nastan vo Skopje", 8.0, locations.get(3)));
        events.add(new Event("D Festival", "Muzicki festival na otvoreno vo Dojran", 9.0, locations.get(4)));
        events.add(new Event("Folk Fest Valandovo", "Festival na narodna muzika vo Valandovo", 7.5, locations.get(0)));
        events.add(new Event("Galichka Svadba", "Tradicionalna svadba vo Galichnik", 8.9, locations.get(1)));
        events.add(new Event("Prilepski Pivofest", "Festival na pivo i muzika vo Prilep", 8.3, locations.get(2)));
        events.add(new Event("Mladinski Kulturn Centar (MKC) Nastani", "Kulturni i muzicki nastani vo Skopje", 8.7, locations.get(3)));
        events.add(new Event("Bela Nokj", "Noken kulturen nastan so umetnost i muzika vo Skopje", 8.6, locations.get(4)));
    }
}

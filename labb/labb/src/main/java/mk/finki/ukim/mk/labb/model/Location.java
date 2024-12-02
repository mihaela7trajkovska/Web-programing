package mk.finki.ukim.mk.labb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String capacity;
    private String description;

    @OneToMany(mappedBy = "location")
    private List<Event> events;

    public Location(long id, String name, String address, String capacity, String description) {
        this.id=id;
        this.name=name;
        this.address=address;
        this.capacity=capacity;
        this.description=description;
    }
}

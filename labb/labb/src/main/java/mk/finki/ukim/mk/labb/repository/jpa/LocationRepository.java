package mk.finki.ukim.mk.labb.repository.jpa;

import mk.finki.ukim.mk.labb.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}


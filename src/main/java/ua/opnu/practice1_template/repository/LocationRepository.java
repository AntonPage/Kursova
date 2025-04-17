package ua.opnu.practice1_template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.opnu.practice1_template.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
}

package ua.opnu.practice1_template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.opnu.practice1_template.model.Location;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {

  @Query("SELECT l FROM Location l ORDER BY (SELECT COUNT(e) FROM Exhibition e WHERE e.location = l) DESC")
  List<Location> findTopLocationsByExhibitionCount();
}

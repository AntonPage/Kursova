package ua.opnu.practice1_template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.opnu.practice1_template.model.Exhibit;

import java.util.List;

public interface ExhibitRepository extends JpaRepository<Exhibit, Long> {

  List<Exhibit> findByYearCreated(int year);

  @Query("SELECT e FROM Exhibit e WHERE e.id NOT IN (SELECT ee.exhibit.id FROM ExhibitionEntry ee)")
  List<Exhibit> findExhibitsWithoutExhibition();
}

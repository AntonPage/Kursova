package ua.opnu.practice1_template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.opnu.practice1_template.model.Exhibition;

import java.time.LocalDate;
import java.util.List;

public interface ExhibitionRepository extends JpaRepository<Exhibition, Long> {

  @Query("SELECT e FROM Exhibition e WHERE e.startDate <= :today AND e.endDate >= :today")
  List<Exhibition> findByStartDateBeforeAndEndDateAfter(@Param("today") LocalDate today1, @Param("today") LocalDate today2);

  @Query("SELECT DISTINCT ex.exhibition FROM ExhibitionEntry ex WHERE ex.exhibit.artist.id = :artistId")
  List<Exhibition> findByArtistId(@Param("artistId") Long artistId);
}

package ua.opnu.practice1_template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.opnu.practice1_template.model.Artist;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
  List<Artist> findByCountry(String country);
}

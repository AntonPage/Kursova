package ua.opnu.practice1_template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.opnu.practice1_template.model.Artist;


public interface ArtistRepository extends JpaRepository<Artist, Long> {
}

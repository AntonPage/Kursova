package ua.opnu.practice1_template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.opnu.practice1_template.model.ExhibitionEntry;
import java.util.List;

public interface ExhibitionEntryRepository extends JpaRepository<ExhibitionEntry, Long> {
  List<ExhibitionEntry> findByExhibitionId(Long exhibitionId);
}

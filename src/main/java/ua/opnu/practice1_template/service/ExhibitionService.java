package ua.opnu.practice1_template.service;

import org.springframework.stereotype.Service;
import ua.opnu.practice1_template.model.Exhibition;
import ua.opnu.practice1_template.repository.ExhibitionRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ExhibitionService {

  private final ExhibitionRepository exhibitionRepository;

  public ExhibitionService(ExhibitionRepository exhibitionRepository) {
    this.exhibitionRepository = exhibitionRepository;
  }

  public List<Exhibition> getAll() {
    return exhibitionRepository.findAll();
  }

  public Optional<Exhibition> getById(Long id) {
    return exhibitionRepository.findById(id);
  }

  public Exhibition create(Exhibition exhibition) {
    return exhibitionRepository.save(exhibition);
  }

  public Exhibition update(Long id, Exhibition updatedExhibition) {
    return exhibitionRepository.findById(id).map(exhibition -> {
      exhibition.setTitle(updatedExhibition.getTitle());
      exhibition.setStartDate(updatedExhibition.getStartDate());
      exhibition.setEndDate(updatedExhibition.getEndDate());
      exhibition.setLocation(updatedExhibition.getLocation());
      return exhibitionRepository.save(exhibition);
    }).orElse(null);
  }

  public void delete(Long id) {
    exhibitionRepository.deleteById(id);
  }

  public List<Exhibition> findCurrentExhibitions() {
    LocalDate today = LocalDate.now();
    return exhibitionRepository.findByStartDateBeforeAndEndDateAfter(today, today);
  }

  public List<Exhibition> findByArtistId(Long artistId) {
    return exhibitionRepository.findByArtistId(artistId);
  }

  public long countExhibitions() {
    return exhibitionRepository.count();
  }
}

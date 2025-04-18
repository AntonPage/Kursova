package ua.opnu.practice1_template.service;

import org.springframework.stereotype.Service;
import ua.opnu.practice1_template.model.ExhibitionEntry;
import ua.opnu.practice1_template.repository.ExhibitionEntryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ExhibitionEntryService {

  private final ExhibitionEntryRepository entryRepository;

  public ExhibitionEntryService(ExhibitionEntryRepository entryRepository) {
    this.entryRepository = entryRepository;
  }

  // Додати експонат до виставки
  public ExhibitionEntry assignExhibitToExhibition(ExhibitionEntry entry) {
    return entryRepository.save(entry);
  }

  // Видалити експонат з виставки
  public void removeEntry(Long id) {
    entryRepository.deleteById(id);
  }

  // Отримати експонат за ID
  public Optional<ExhibitionEntry> getById(Long id) {
    return entryRepository.findById(id);
  }

  // Отримати всі експонати
  public List<ExhibitionEntry> getAll() {
    return entryRepository.findAll();
  }

  // Отримати експонати для певної виставки
  public List<ExhibitionEntry> getByExhibitionId(Long exhibitionId) {
    return entryRepository.findByExhibitionId(exhibitionId);
  }
}

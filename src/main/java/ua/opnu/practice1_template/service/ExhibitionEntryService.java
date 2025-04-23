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

  public ExhibitionEntry assignExhibitToExhibition(ExhibitionEntry entry) {
    return entryRepository.save(entry);
  }

  public void removeEntry(Long id) {
    entryRepository.deleteById(id);
  }

  public Optional<ExhibitionEntry> getById(Long id) {
    return entryRepository.findById(id);
  }

  public List<ExhibitionEntry> getAll() {
    return entryRepository.findAll();
  }

  public List<ExhibitionEntry> getByExhibitionId(Long exhibitionId) {
    return entryRepository.findByExhibitionId(exhibitionId);
  }
}

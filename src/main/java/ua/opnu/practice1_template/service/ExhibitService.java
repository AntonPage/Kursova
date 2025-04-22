package ua.opnu.practice1_template.service;

import org.springframework.stereotype.Service;
import ua.opnu.practice1_template.model.Exhibit;
import ua.opnu.practice1_template.repository.ExhibitRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ExhibitService {

  private final ExhibitRepository exhibitRepository;

  public ExhibitService(ExhibitRepository exhibitRepository) {
    this.exhibitRepository = exhibitRepository;
  }

  public List<Exhibit> getAll() {
    return exhibitRepository.findAll();
  }

  public Optional<Exhibit> getById(Long id) {
    return exhibitRepository.findById(id);
  }

  public Exhibit create(Exhibit exhibit) {
    return exhibitRepository.save(exhibit);
  }

  public Exhibit update(Long id, Exhibit updatedExhibit) {
    return exhibitRepository.findById(id).map(exhibit -> {
      exhibit.setTitle(updatedExhibit.getTitle());
      exhibit.setDescription(updatedExhibit.getDescription());
      exhibit.setYearCreated(updatedExhibit.getYearCreated());
      exhibit.setArtist(updatedExhibit.getArtist());
      return exhibitRepository.save(exhibit);
    }).orElse(null);
  }

  public void delete(Long id) {
    exhibitRepository.deleteById(id);
  }

  public List<Exhibit> findByYear(int year) {
    return exhibitRepository.findByYearCreated(year);
  }

  public List<Exhibit> findWithoutExhibition() {
    return exhibitRepository.findExhibitsWithoutExhibition();
  }
}

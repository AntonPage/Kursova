package ua.opnu.practice1_template.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.practice1_template.model.ExhibitionEntry;
import ua.opnu.practice1_template.service.ExhibitionEntryService;

import java.util.List;

@RestController
@RequestMapping("/api/exhibition-entries")
public class ExhibitionEntryController {

  private final ExhibitionEntryService entryService;

  public ExhibitionEntryController(ExhibitionEntryService entryService) {
    this.entryService = entryService;
  }

  // Додати експонат до виставки
  @PostMapping
  public ExhibitionEntry assignExhibitToExhibition(@RequestBody ExhibitionEntry entry) {
    return entryService.assignExhibitToExhibition(entry);
  }

  // Видалити експонат з виставки
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> removeEntry(@PathVariable Long id) {
    entryService.removeEntry(id);
    return ResponseEntity.noContent().build();
  }

  // Отримати експонат за ID
  @GetMapping("/{id}")
  public ResponseEntity<ExhibitionEntry> getById(@PathVariable Long id) {
    return entryService.getById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  // Отримати всі експонати
  @GetMapping
  public List<ExhibitionEntry> getAll() {
    return entryService.getAll();
  }

  // Отримати експонати по ID виставки
  @GetMapping("/by-exhibition/{exhibitionId}")
  public List<ExhibitionEntry> getByExhibitionId(@PathVariable Long exhibitionId) {
    return entryService.getByExhibitionId(exhibitionId);
  }
}

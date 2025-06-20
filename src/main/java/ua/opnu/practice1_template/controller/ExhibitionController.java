package ua.opnu.practice1_template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.practice1_template.model.Exhibition;
import ua.opnu.practice1_template.service.ExhibitionService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/exhibitions")
public class ExhibitionController {

  private final ExhibitionService exhibitionService;

  @Autowired
  public ExhibitionController(ExhibitionService exhibitionService) {
    this.exhibitionService = exhibitionService;
  }

  @GetMapping
  public List<Exhibition> getAll() {
    return exhibitionService.getAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Exhibition> getById(@PathVariable Long id) {
    return exhibitionService.getById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public Exhibition create(@RequestBody Exhibition exhibition) {
    return exhibitionService.create(exhibition);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Exhibition> update(@PathVariable Long id, @RequestBody Exhibition exhibition) {
    Exhibition updated = exhibitionService.update(id, exhibition);
    if (updated == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(updated);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    exhibitionService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/current")
  public List<Exhibition> getCurrentExhibitions() {
    return exhibitionService.findCurrentExhibitions();
  }

  @GetMapping("/artist/{artistId}")
  public List<Exhibition> getExhibitionsByArtist(@PathVariable Long artistId) {
    return exhibitionService.findByArtistId(artistId);
  }

  @GetMapping("/statistics")
  public Map<String, Object> getExhibitionStatistics() {
    Map<String, Object> stats = new HashMap<>();
    stats.put("total", exhibitionService.countExhibitions());
    return stats;
  }
}

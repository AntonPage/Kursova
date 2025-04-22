package ua.opnu.practice1_template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.practice1_template.model.Exhibit;
import ua.opnu.practice1_template.service.ExhibitService;

import java.util.List;

@RestController
@RequestMapping("/api/exhibits")
public class ExhibitController {

  private final ExhibitService exhibitService;

  @Autowired
  public ExhibitController(ExhibitService exhibitService) {
    this.exhibitService = exhibitService;
  }

  @GetMapping
  public List<Exhibit> getAll() {
    return exhibitService.getAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Exhibit> getById(@PathVariable Long id) {
    return exhibitService.getById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public Exhibit create(@RequestBody Exhibit exhibit) {
    return exhibitService.create(exhibit);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Exhibit> update(@PathVariable Long id, @RequestBody Exhibit exhibit) {
    Exhibit updated = exhibitService.update(id, exhibit);
    if (updated == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(updated);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    exhibitService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/byYear/{year}")
  public List<Exhibit> getExhibitsByYear(@PathVariable int year) {
    return exhibitService.findByYear(year);
  }

  @GetMapping("/without-exhibition")
  public List<Exhibit> getWithoutExhibition() {
    return exhibitService.findWithoutExhibition();
  }
}

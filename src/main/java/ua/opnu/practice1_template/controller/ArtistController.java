package ua.opnu.practice1_template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.practice1_template.model.Artist;
import ua.opnu.practice1_template.service.ArtistService;

import java.util.List;

@RestController
@RequestMapping("/api/artists")
public class ArtistController {

  private final ArtistService artistService;

  @Autowired
  public ArtistController(ArtistService artistService) {
    this.artistService = artistService;
  }

  @GetMapping
  public List<Artist> getAll() {
    return artistService.getAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Artist> getById(@PathVariable Long id) {
    return artistService.getById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public Artist create(@RequestBody Artist artist) {
    return artistService.create(artist);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Artist> update(@PathVariable Long id, @RequestBody Artist artist) {
    Artist updated = artistService.update(id, artist);
    if (updated == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(updated);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    artistService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/by-country")
  public List<Artist> getByCountry(@RequestParam String country) {
    return artistService.findByCountry(country);
  }
}

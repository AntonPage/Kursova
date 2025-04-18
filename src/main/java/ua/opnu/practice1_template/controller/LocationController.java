package ua.opnu.practice1_template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.practice1_template.model.Location;
import ua.opnu.practice1_template.service.LocationService;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

  private final LocationService locationService;

  @Autowired
  public LocationController(LocationService locationService) {
    this.locationService = locationService;
  }

  @GetMapping
  public List<Location> getAll() {
    return locationService.getAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Location> getById(@PathVariable Long id) {
    return locationService.getById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public Location create(@RequestBody Location location) {
    return locationService.create(location);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Location> update(@PathVariable Long id, @RequestBody Location location) {
    Location updated = locationService.update(id, location);
    if (updated == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(updated);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    locationService.delete(id);
    return ResponseEntity.noContent().build();
  }
}

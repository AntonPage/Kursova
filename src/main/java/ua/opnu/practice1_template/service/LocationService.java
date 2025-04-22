package ua.opnu.practice1_template.service;

import org.springframework.stereotype.Service;
import ua.opnu.practice1_template.model.Location;
import ua.opnu.practice1_template.repository.LocationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

  private final LocationRepository locationRepository;

  public LocationService(LocationRepository locationRepository) {
    this.locationRepository = locationRepository;
  }

  public List<Location> getAll() {
    return locationRepository.findAll();
  }

  public Optional<Location> getById(Long id) {
    return locationRepository.findById(id);
  }

  public Location create(Location location) {
    return locationRepository.save(location);
  }

  public Location update(Long id, Location updatedLocation) {
    return locationRepository.findById(id).map(location -> {
      location.setName(updatedLocation.getName());
      location.setAddress(updatedLocation.getAddress());
      return locationRepository.save(location);
    }).orElse(null);
  }

  public void delete(Long id) {
    locationRepository.deleteById(id);
  }

  public List<Location> getTopLocations() {
    return locationRepository.findTopLocationsByExhibitionCount();
  }
}

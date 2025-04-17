package ua.opnu.practice1_template.service;

import org.springframework.stereotype.Service;
import ua.opnu.practice1_template.model.Artist;
import ua.opnu.practice1_template.repository.ArtistRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {

  private final ArtistRepository artistRepository;

  public ArtistService(ArtistRepository artistRepository) {
    this.artistRepository = artistRepository;
  }

  public List<Artist> getAll() {
    return artistRepository.findAll();
  }

  public Optional<Artist> getById(Long id) {
    return artistRepository.findById(id);
  }

  public Artist create(Artist artist) {
    return artistRepository.save(artist);
  }

  public Artist update(Long id, Artist updatedArtist) {
    return artistRepository.findById(id).map(artist -> {
      artist.setName(updatedArtist.getName());
      artist.setCountry(updatedArtist.getCountry());
      return artistRepository.save(artist);
    }).orElse(null);
  }

  public void delete(Long id) {
    artistRepository.deleteById(id);
  }
}

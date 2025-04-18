package ua.opnu.practice1_template.model;

import jakarta.persistence.*;

@Entity
public class Exhibit {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;
  private String description;
  private Integer yearCreated;

  @ManyToOne
  @JoinColumn(name = "artist_id")
  private Artist artist;

  public Exhibit() {}

  public Exhibit(Long id, String title, String description, Integer yearCreated, Artist artist) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.yearCreated = yearCreated;
    this.artist = artist;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getYearCreated() {
    return yearCreated;
  }

  public void setYearCreated(Integer yearCreated) {
    this.yearCreated = yearCreated;
  }

  public Artist getArtist() {
    return artist;
  }

  public void setArtist(Artist artist) {
    this.artist = artist;
  }
}

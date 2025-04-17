package ua.opnu.practice1_template.model;

import jakarta.persistence.*;
import lombok.*;
import ua.opnu.practice1_template.model.Artist;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
}

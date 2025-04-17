package ua.opnu.practice1_template.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExhibitionEntry {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "exhibition_id")
  private Exhibition exhibition;

  @ManyToOne
  @JoinColumn(name = "exhibit_id")
  private Exhibit exhibit;
}

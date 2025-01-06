package uz.pdp.entity_relationship_diagram.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Showing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime showing_date;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Theater theater;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Movie movie;
}

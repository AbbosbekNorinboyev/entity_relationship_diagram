package uz.pdp.entity_relationship_diagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.entity_relationship_diagram.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
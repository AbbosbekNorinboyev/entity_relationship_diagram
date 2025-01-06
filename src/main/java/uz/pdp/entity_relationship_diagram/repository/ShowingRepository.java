package uz.pdp.entity_relationship_diagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.entity_relationship_diagram.entity.Showing;

public interface ShowingRepository extends JpaRepository<Showing, Integer> {
}
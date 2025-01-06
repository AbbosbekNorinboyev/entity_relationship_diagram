package uz.pdp.entity_relationship_diagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.entity_relationship_diagram.entity.Cinema;
import uz.pdp.entity_relationship_diagram.entity.Theater;

import java.util.Optional;

public interface CinemaRepository extends JpaRepository<Cinema, Integer> {
    @Query("from Theater t where t.id=?1 and t.cinema.id=?2")
    Optional<Theater> getTheaterByIdAndCinemaId(Integer theaterId, Integer cinemaId);
}
package uz.pdp.entity_relationship_diagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.entity_relationship_diagram.entity.Theater;

public interface TheaterRepository extends JpaRepository<Theater, Integer> {
    @Query(value = "delete from theater as t where t.cinema.id=?1", nativeQuery = true)
    @Modifying
    @Transactional
    void deleteTheaterByCinemaId(Integer cinemaId);
}
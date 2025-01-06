package uz.pdp.entity_relationship_diagram.mapper;

import org.springframework.stereotype.Component;
import uz.pdp.entity_relationship_diagram.dto.CinemaCreateDTO;
import uz.pdp.entity_relationship_diagram.entity.Cinema;

@Component
public class CinemaMapper {
    public Cinema toEntity(CinemaCreateDTO cinemaCreateDTO) {
        return Cinema.builder()
                .name(cinemaCreateDTO.getName())
                .address(cinemaCreateDTO.getAddress())
                .phone(cinemaCreateDTO.getPhone())
                .createdAt(cinemaCreateDTO.getCreatedAt())
                .build();
    }

    public CinemaCreateDTO toDto(Cinema cinema) {
        return CinemaCreateDTO.builder()
                .name(cinema.getName())
                .address(cinema.getAddress())
                .phone(cinema.getPhone())
                .createdAt(cinema.getCreatedAt())
                .build();
    }
}

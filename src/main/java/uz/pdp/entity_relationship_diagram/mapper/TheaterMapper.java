package uz.pdp.entity_relationship_diagram.mapper;

import org.springframework.stereotype.Component;
import uz.pdp.entity_relationship_diagram.dto.TheaterCreateDTO;
import uz.pdp.entity_relationship_diagram.entity.Theater;

@Component
public class TheaterMapper {
    public Theater toEntity(TheaterCreateDTO theaterCreateDTO) {
        return Theater.builder()
                .capacity(theaterCreateDTO.getCapacity())
                .createdAt(theaterCreateDTO.getCreatedAt())
                .build();
    }

    public TheaterCreateDTO toDto(Theater theater) {
        return TheaterCreateDTO.builder()
                .capacity(theater.getCapacity())
                .createdAt(theater.getCreatedAt())
                .build();
    }
}

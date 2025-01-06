package uz.pdp.entity_relationship_diagram.mapper;

import org.springframework.stereotype.Component;
import uz.pdp.entity_relationship_diagram.dto.ShowingCreateDTO;
import uz.pdp.entity_relationship_diagram.entity.Showing;

@Component
public class ShowingMapper {
    public Showing toEntity(ShowingCreateDTO showingCreateDTO) {
        return Showing.builder()
                .showing_date(showingCreateDTO.getShowing_date())
                .build();
    }

    public ShowingCreateDTO toDto(Showing showing) {
        return ShowingCreateDTO.builder()
                .showing_date(showing.getShowing_date())
                .build();
    }
}

package uz.pdp.entity_relationship_diagram.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import uz.pdp.entity_relationship_diagram.enums.Rating;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MovieCreateDTO {
    @NotBlank(message = "name can not be null or empty")
    private String name;
    private Rating rating;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}

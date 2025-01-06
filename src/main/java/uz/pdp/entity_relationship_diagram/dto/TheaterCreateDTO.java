package uz.pdp.entity_relationship_diagram.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class TheaterCreateDTO {
    @NotNull(message = "capacity can not be null or empty")
    @Positive(message = "The number must be positive")
    private Integer capacity;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}

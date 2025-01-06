package uz.pdp.entity_relationship_diagram.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CinemaCreateDTO {
    @NotBlank(message = "name can not be null or empty")
    private String name;
    @NotBlank(message = "address can not be null or empty")
    private String address;
    @NotBlank(message = "phone can not be null or empty")
    private String phone;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}

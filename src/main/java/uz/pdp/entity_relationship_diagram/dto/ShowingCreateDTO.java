package uz.pdp.entity_relationship_diagram.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ShowingCreateDTO {
    @NotNull(message = "showing date can not be null or empty") // date lar uchun @NotNull dan foydalanish kerak check yozishda
    private LocalDateTime showing_date;
}

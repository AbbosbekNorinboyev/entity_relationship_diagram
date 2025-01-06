package uz.pdp.entity_relationship_diagram.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO<T> {
    private Integer code;
    private String message;
    private Boolean success;
    private T data;
    private List<ErrorDTO> errors;
}
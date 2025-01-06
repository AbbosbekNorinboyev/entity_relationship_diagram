package uz.pdp.entity_relationship_diagram.validation;

import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Component;
import uz.pdp.entity_relationship_diagram.dto.ErrorDTO;
import uz.pdp.entity_relationship_diagram.dto.MovieCreateDTO;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieValidation {
    List<ErrorDTO> errors = new ArrayList<>();

    public List<ErrorDTO> errorDTOS(MovieCreateDTO movieCreateDTO) {
        if (StringUtils.isBlank(movieCreateDTO.getName())) {
            errors.add(new ErrorDTO("name", "can not be null or empty"));
        }
        return errors;
    }
}

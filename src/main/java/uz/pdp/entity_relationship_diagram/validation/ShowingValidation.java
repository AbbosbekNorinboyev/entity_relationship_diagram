package uz.pdp.entity_relationship_diagram.validation;

import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Component;
import uz.pdp.entity_relationship_diagram.dto.ErrorDTO;
import uz.pdp.entity_relationship_diagram.dto.ShowingCreateDTO;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShowingValidation {
    List<ErrorDTO> errors = new ArrayList<>();

    public List<ErrorDTO> validate(ShowingCreateDTO showingCreateDTO) {
        if (StringUtils.isBlank(String.valueOf(showingCreateDTO.getShowing_date()))) {
            errors.add(new ErrorDTO("showing_date", "can not be null or empty"));
        }
        return errors;
    }
}

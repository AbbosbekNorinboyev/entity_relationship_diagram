package uz.pdp.entity_relationship_diagram.validation;

import io.micrometer.common.util.StringUtils;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.stereotype.Component;
import uz.pdp.entity_relationship_diagram.dto.ErrorDTO;
import uz.pdp.entity_relationship_diagram.dto.TheaterCreateDTO;

import java.util.ArrayList;
import java.util.List;

@Component
public class TheaterValidation {
    List<ErrorDTO> errors = new ArrayList<>();

    public List<ErrorDTO> validate(TheaterCreateDTO theaterCreateDTO) {
        if (StringUtils.isBlank(String.valueOf(theaterCreateDTO.getCapacity()))) {
            errors.add(new ErrorDTO("capacity", "can not be null or empty"));
        }
        return errors;
    }
}

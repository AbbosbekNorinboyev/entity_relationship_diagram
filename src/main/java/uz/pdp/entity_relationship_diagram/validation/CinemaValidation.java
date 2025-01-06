package uz.pdp.entity_relationship_diagram.validation;

import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Component;
import uz.pdp.entity_relationship_diagram.dto.CinemaCreateDTO;
import uz.pdp.entity_relationship_diagram.dto.ErrorDTO;

import java.util.ArrayList;
import java.util.List;

@Component
public class CinemaValidation {
    ArrayList<ErrorDTO> errors = new ArrayList<>();

    public List<ErrorDTO> errorDTOS(CinemaCreateDTO cinemaCreateDTO) {
        if (StringUtils.isBlank(cinemaCreateDTO.getName())) {
            errors.add(new ErrorDTO("name", "can not be null or empty"));
        }
        if (StringUtils.isBlank(cinemaCreateDTO.getAddress())) {
            errors.add(new ErrorDTO("address", "can not be null or empty"));
        }
        if (StringUtils.isBlank(cinemaCreateDTO.getPhone())) {
            errors.add(new ErrorDTO("phone", "can not be null or empty"));
        }
        return errors;
    }
}

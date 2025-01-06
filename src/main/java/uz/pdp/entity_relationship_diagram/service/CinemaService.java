package uz.pdp.entity_relationship_diagram.service;

import jakarta.validation.constraints.NotNull;
import uz.pdp.entity_relationship_diagram.dto.CinemaCreateDTO;
import uz.pdp.entity_relationship_diagram.dto.ResponseDTO;
import uz.pdp.entity_relationship_diagram.entity.Cinema;

import java.util.List;

public interface CinemaService {
    ResponseDTO<Cinema> createCinema(@NotNull CinemaCreateDTO cinemaCreateDTO);

    ResponseDTO<Cinema> getCinema(@NotNull Integer id);

    ResponseDTO<List<Cinema>> getAllCinema();

    ResponseDTO<Cinema> updateCinema(@NotNull CinemaCreateDTO cinemaCreateDTO,
                                     @NotNull Integer cinemaId);
}

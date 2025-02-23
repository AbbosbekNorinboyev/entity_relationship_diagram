package uz.pdp.entity_relationship_diagram.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.entity_relationship_diagram.dto.CinemaCreateDTO;
import uz.pdp.entity_relationship_diagram.dto.ResponseDTO;
import uz.pdp.entity_relationship_diagram.entity.Cinema;
import uz.pdp.entity_relationship_diagram.service.CinemaService;

import java.util.List;

@RestController
@RequestMapping("/api/cinemas")
@RequiredArgsConstructor
public class CinemaController {
    private final CinemaService cinemaService;

    @PostMapping
    public ResponseDTO<Cinema> createCinema(@Valid @RequestBody CinemaCreateDTO cinemaCreateDTO) {
        return cinemaService.createCinema(cinemaCreateDTO);
    }

    @GetMapping("/{id}")
    public ResponseDTO<Cinema> getCinema(@PathVariable Integer id) {
        return cinemaService.getCinema(id);
    }

    @GetMapping
    public ResponseDTO<List<Cinema>> getAllCinema() {
        return cinemaService.getAllCinema();
    }

    @PutMapping("/{cinemaId}")
    public ResponseDTO<Cinema> updateCinema(@Valid @RequestBody CinemaCreateDTO cinemaCreateDTO,
                                            @PathVariable Integer cinemaId) {
        return cinemaService.updateCinema(cinemaCreateDTO, cinemaId);
    }
}

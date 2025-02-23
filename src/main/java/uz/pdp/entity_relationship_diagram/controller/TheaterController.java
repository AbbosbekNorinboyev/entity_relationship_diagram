package uz.pdp.entity_relationship_diagram.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.entity_relationship_diagram.dto.ResponseDTO;
import uz.pdp.entity_relationship_diagram.dto.TheaterCreateDTO;
import uz.pdp.entity_relationship_diagram.entity.Theater;
import uz.pdp.entity_relationship_diagram.service.TheaterService;

import java.util.List;

@RestController
@RequestMapping("/api/theaters")
@RequiredArgsConstructor
public class TheaterController {
    private final TheaterService theaterService;

    @PostMapping
    public ResponseDTO<Theater> createTheater(@Valid @RequestBody TheaterCreateDTO theaterCreateDTO,
                                              @RequestParam Integer cinemaId) {
        return theaterService.createTheater(theaterCreateDTO, cinemaId);
    }

    @GetMapping("/{id}")
    public ResponseDTO<Theater> getTheater(@PathVariable Integer id) {
        return theaterService.getTheater(id);
    }

    @GetMapping
    public ResponseDTO<List<Theater>> getAllTheater() {
        return theaterService.getAllTheater();
    }

    @PutMapping("/{theaterId}/{cinemaId}")
    public ResponseDTO<Theater> createTheater(@Valid @RequestBody TheaterCreateDTO theaterCreateDTO,
                                              @PathVariable Integer theaterId,
                                              @PathVariable Integer cinemaId) {
        return theaterService.updateTheater(theaterCreateDTO, theaterId, cinemaId);
    }

}

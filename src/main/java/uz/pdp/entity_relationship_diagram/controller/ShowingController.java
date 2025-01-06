package uz.pdp.entity_relationship_diagram.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.entity_relationship_diagram.dto.ResponseDTO;
import uz.pdp.entity_relationship_diagram.dto.ShowingCreateDTO;
import uz.pdp.entity_relationship_diagram.entity.Showing;
import uz.pdp.entity_relationship_diagram.service.impl.ShowingServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/showings")
@RequiredArgsConstructor
public class ShowingController {
    private final ShowingServiceImpl showingService;

    @PostMapping
    public ResponseDTO<Showing> createShowing(@Valid @RequestBody ShowingCreateDTO showingCreateDTO,
                                              @RequestParam Integer theaterId,
                                              @RequestParam Integer movieId) {
        return showingService.createShowing(showingCreateDTO, theaterId, movieId);
    }

    @GetMapping("/{id}")
    public ResponseDTO<Showing> getShowing(@PathVariable Integer id) {
        return showingService.getShowing(id);
    }

    @GetMapping
    public ResponseDTO<List<Showing>> getAllShowing() {
        return showingService.getAllShowing();
    }

    @PutMapping("/{showingId}/{theaterId}/{movieId}")
    public ResponseDTO<Showing> updateShowing(@Valid @RequestBody ShowingCreateDTO showingCreateDTO,
                                              @PathVariable Integer showingId,
                                              @PathVariable Integer theaterId,
                                              @PathVariable Integer movieId) {
        return showingService.updateShowing(showingCreateDTO, showingId, theaterId, movieId);
    }
}

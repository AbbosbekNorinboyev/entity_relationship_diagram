package uz.pdp.entity_relationship_diagram.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.entity_relationship_diagram.dto.MovieCreateDTO;
import uz.pdp.entity_relationship_diagram.dto.ResponseDTO;
import uz.pdp.entity_relationship_diagram.entity.Movie;
import uz.pdp.entity_relationship_diagram.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @PostMapping
    public ResponseDTO<Movie> createMovie(@Valid @RequestBody MovieCreateDTO movieCreateDTO) {
        return movieService.createMovie(movieCreateDTO);
    }

    @GetMapping("/{id}")
    public ResponseDTO<Movie> getMovie(@PathVariable Integer id) {
        return movieService.getMovie(id);
    }

    @GetMapping
    public ResponseDTO<List<Movie>> getAllMovie() {
        return movieService.getAllMovie();
    }

    @PutMapping("/{movieId}")
    public ResponseDTO<Movie> updateMovie(@Valid @RequestBody MovieCreateDTO movieCreateDTO,
                                          @PathVariable Integer movieId) {
        return movieService.updateMovie(movieCreateDTO, movieId);
    }
}

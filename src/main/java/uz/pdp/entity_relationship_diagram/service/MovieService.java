package uz.pdp.entity_relationship_diagram.service;

import org.springframework.lang.NonNull;
import uz.pdp.entity_relationship_diagram.dto.MovieCreateDTO;
import uz.pdp.entity_relationship_diagram.dto.ResponseDTO;
import uz.pdp.entity_relationship_diagram.entity.Movie;

import java.util.List;

public interface MovieService {
    ResponseDTO<Movie> createMovie(@NonNull MovieCreateDTO movieCreateDTO);

    ResponseDTO<Movie> getMovie(@NonNull Integer id);

    ResponseDTO<List<Movie>> getAllMovie();

    ResponseDTO<Movie> updateMovie(@NonNull MovieCreateDTO movieCreateDTO,
                                   @NonNull Integer movieId);
}

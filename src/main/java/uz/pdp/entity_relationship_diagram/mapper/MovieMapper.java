package uz.pdp.entity_relationship_diagram.mapper;

import org.springframework.stereotype.Component;
import uz.pdp.entity_relationship_diagram.dto.MovieCreateDTO;
import uz.pdp.entity_relationship_diagram.entity.Movie;

@Component
public class MovieMapper {
    public Movie toEntity(MovieCreateDTO movieCreateDTO) {
        return Movie.builder()
                .name(movieCreateDTO.getName())
                .rating(movieCreateDTO.getRating())
                .createdAt(movieCreateDTO.getCreatedAt())
                .build();
    }

    public MovieCreateDTO toDto(Movie movie) {
        return MovieCreateDTO.builder()
                .name(movie.getName())
                .rating(movie.getRating())
                .createdAt(movie.getCreatedAt())
                .build();
    }
}

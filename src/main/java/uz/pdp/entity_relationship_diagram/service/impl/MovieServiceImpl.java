package uz.pdp.entity_relationship_diagram.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import uz.pdp.entity_relationship_diagram.dto.MovieCreateDTO;
import uz.pdp.entity_relationship_diagram.dto.ResponseDTO;
import uz.pdp.entity_relationship_diagram.entity.Movie;
import uz.pdp.entity_relationship_diagram.exception.ResourceNotFoundException;
import uz.pdp.entity_relationship_diagram.mapper.MovieMapper;
import uz.pdp.entity_relationship_diagram.repository.MovieRepository;
import uz.pdp.entity_relationship_diagram.service.MovieService;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieMapper movieMapper;
    private final MovieRepository movieRepository;

    @Override
    public ResponseDTO<Movie> createMovie(@NonNull MovieCreateDTO movieCreateDTO) {
        Movie movie = movieMapper.toEntity(movieCreateDTO);
        movie.setCreatedAt(LocalDateTime.now());
        movieRepository.save(movie);
        return ResponseDTO.<Movie>builder()
                .code(200)
                .success(true)
                .message("Successfully saved")
                .data(movie)
                .build();
    }

    @Override
    public ResponseDTO<Movie> getMovie(@NonNull Integer id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found: " + id));
        return ResponseDTO.<Movie>builder()
                .code(200)
                .success(true)
                .message("Movie found")
                .data(movie)
                .build();
    }

    @Override
    public ResponseDTO<List<Movie>> getAllMovie() {
        List<Movie> movies = movieRepository.findAll();
        return ResponseDTO.<List<Movie>>builder()
                .code(200)
                .success(true)
                .message("Movie list found")
                .data(movies)
                .build();
    }

    @Override
    public ResponseDTO<Movie> updateMovie(@NonNull MovieCreateDTO movieCreateDTO,
                                          @NonNull Integer movieId) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found: " + movieId));
        movie.setName(movieCreateDTO.getName());
        movie.setRating(movieCreateDTO.getRating());
        movie.setUpdatedAt(LocalDateTime.now());
        movieRepository.save(movie);
        return ResponseDTO.<Movie>builder()
                .code(200)
                .success(true)
                .message("Successfully updated")
                .data(movie)
                .build();
    }
}

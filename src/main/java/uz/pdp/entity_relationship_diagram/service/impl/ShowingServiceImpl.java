package uz.pdp.entity_relationship_diagram.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import uz.pdp.entity_relationship_diagram.dto.ResponseDTO;
import uz.pdp.entity_relationship_diagram.dto.ShowingCreateDTO;
import uz.pdp.entity_relationship_diagram.entity.Movie;
import uz.pdp.entity_relationship_diagram.entity.Showing;
import uz.pdp.entity_relationship_diagram.entity.Theater;
import uz.pdp.entity_relationship_diagram.exception.ResourceNotFoundException;
import uz.pdp.entity_relationship_diagram.mapper.ShowingMapper;
import uz.pdp.entity_relationship_diagram.repository.MovieRepository;
import uz.pdp.entity_relationship_diagram.repository.ShowingRepository;
import uz.pdp.entity_relationship_diagram.repository.TheaterRepository;
import uz.pdp.entity_relationship_diagram.service.ShowingService;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowingServiceImpl implements ShowingService {
    private final TheaterRepository theaterRepository;
    private final MovieRepository movieRepository;
    private final ShowingMapper showingMapper;
    private final ShowingRepository showingRepository;

    @Override
    public ResponseDTO<Showing> createShowing(@NonNull ShowingCreateDTO showingCreateDTO,
                                              @NonNull Integer theaterId,
                                              @NonNull Integer movieId) {
        Theater theater = theaterRepository.findById(theaterId)
                .orElseThrow(() -> new ResourceNotFoundException("Theater not found: " + theaterId));
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found: " + movieId));
        Showing showing = showingMapper.toEntity(showingCreateDTO);
        showing.setTheater(theater);
        showing.setMovie(movie);
        showing.setShowing_date(LocalDateTime.now());
        showingRepository.save(showing);
        return ResponseDTO.<Showing>builder()
                .code(200)
                .success(true)
                .message("Successfully saved")
                .data(showing)
                .build();
    }

    @Override
    public ResponseDTO<Showing> getShowing(@NonNull Integer id) {
        Showing showing = showingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Showing not found: " + id));
        return ResponseDTO.<Showing>builder()
                .code(200)
                .success(true)
                .message("Showing found")
                .data(showing)
                .build();
    }

    @Override
    public ResponseDTO<List<Showing>> getAllShowing() {
        List<Showing> showings = showingRepository.findAll();
        return ResponseDTO.<List<Showing>>builder()
                .code(200)
                .success(true)
                .message("Showing list found")
                .data(showings)
                .build();
    }

    @Override
    public ResponseDTO<Showing> updateShowing(@NonNull ShowingCreateDTO showingCreateDTO,
                                              @NonNull Integer showingId,
                                              @NonNull Integer theaterId,
                                              @NonNull Integer movieId) {
        Showing showing = showingRepository.findById(showingId)
                .orElseThrow(() -> new ResourceNotFoundException("Showing not found: " + showingId));
        Theater theater = theaterRepository.findById(theaterId)
                .orElseThrow(() -> new ResourceNotFoundException("Theater not found: " + theaterId));
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found: " + movieId));
        showing.setTheater(theater);
        showing.setMovie(movie);
        showing.setShowing_date(LocalDateTime.now());
        showingRepository.save(showing);
        return ResponseDTO.<Showing>builder()
                .code(200)
                .success(true)
                .message("Successfully updated")
                .data(showing)
                .build();
    }
}

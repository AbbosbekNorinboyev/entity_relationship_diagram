package uz.pdp.entity_relationship_diagram.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import uz.pdp.entity_relationship_diagram.dto.ResponseDTO;
import uz.pdp.entity_relationship_diagram.dto.TheaterCreateDTO;
import uz.pdp.entity_relationship_diagram.entity.Cinema;
import uz.pdp.entity_relationship_diagram.entity.Theater;
import uz.pdp.entity_relationship_diagram.exception.ResourceNotFoundException;
import uz.pdp.entity_relationship_diagram.mapper.TheaterMapper;
import uz.pdp.entity_relationship_diagram.repository.CinemaRepository;
import uz.pdp.entity_relationship_diagram.repository.TheaterRepository;
import uz.pdp.entity_relationship_diagram.service.TheaterService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TheaterServiceImpl implements TheaterService {
    private final TheaterMapper theaterMapper;
    private final CinemaRepository cinemaRepository;
    private final TheaterRepository theaterRepository;
    @Override
    public ResponseDTO<Theater> createTheater(@NonNull TheaterCreateDTO theaterCreateDTO,
                                              @NonNull Integer cinemaId) {
        Cinema cinema = cinemaRepository.findById(cinemaId)
                .orElseThrow(() -> new ResourceNotFoundException("Cinema not found: " + cinemaId));
        Theater theater = theaterMapper.toEntity(theaterCreateDTO);
        theater.setCinema(cinema);
        theater.setCreatedAt(LocalDateTime.now());
        theaterRepository.save(theater);
        return ResponseDTO.<Theater>builder()
                .code(200)
                .success(true)
                .message("Successfully saved")
                .data(theater)
                .build();
    }

    @Override
    public ResponseDTO<Theater> getTheater(@NonNull Integer id) {
        Theater theater = theaterRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Theater not found: " + id));
        return ResponseDTO.<Theater>builder()
                .code(200)
                .success(true)
                .message("Theater found")
                .data(theater)
                .build();
    }

    @Override
    public ResponseDTO<List<Theater>> getAllTheater() {
        List<Theater> theaters = theaterRepository.findAll();
        return ResponseDTO.<List<Theater>>builder()
                .code(200)
                .success(true)
                .message("Theater list found")
                .data(theaters)
                .build();
    }

    @Override
    public ResponseDTO<Theater> updateTheater(@NonNull TheaterCreateDTO theaterCreateDTO,
                                              @NonNull Integer theaterId,
                                              @NonNull Integer cinemaId) {
        Optional<Cinema> cinemaOptional = cinemaRepository.findById(cinemaId);
        if (cinemaOptional.isEmpty()) {
            ResponseDTO.<Cinema>builder()
                    .code(404)
                    .message("Teacher not found")
                    .build();
        }
        Cinema cinema = cinemaOptional.get();
        Optional<Theater> optionalTheater = cinemaRepository.getTheaterByIdAndCinemaId(theaterId, cinema.getId());
        if (optionalTheater.isPresent()) {
            Theater theater = optionalTheater.get();
            theater.setCapacity(theaterCreateDTO.getCapacity());
            theater.setCinema(cinema);
            theater.setUpdatedAt(LocalDateTime.now());
            theaterRepository.save(theater);
            return ResponseDTO.<Theater>builder()
                    .code(200)
                    .success(true)
                    .message("Successfully updated")
                    .build();
        }
        return ResponseDTO.<Theater>builder()
                .code(404)
                .success(false)
                .message("Theater not found")
                .build();
    }
}

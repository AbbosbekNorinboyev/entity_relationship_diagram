package uz.pdp.entity_relationship_diagram.service.impl;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.entity_relationship_diagram.dto.CinemaCreateDTO;
import uz.pdp.entity_relationship_diagram.dto.ErrorDTO;
import uz.pdp.entity_relationship_diagram.dto.ResponseDTO;
import uz.pdp.entity_relationship_diagram.entity.Cinema;
import uz.pdp.entity_relationship_diagram.mapper.CinemaMapper;
import uz.pdp.entity_relationship_diagram.repository.CinemaRepository;
import uz.pdp.entity_relationship_diagram.repository.TheaterRepository;
import uz.pdp.entity_relationship_diagram.service.CinemaService;
import uz.pdp.entity_relationship_diagram.validation.CinemaValidation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CinemaServiceImpl implements CinemaService {
    private final CinemaRepository cinemaRepository;
    private final CinemaMapper cinemaMapper;
    private final CinemaValidation cinemaValidation;
    private final TheaterRepository theaterRepository;

    @Override
    public ResponseDTO<Cinema> createCinema(CinemaCreateDTO cinemaCreateDTO) {
        List<ErrorDTO> errorDTOS = cinemaValidation.errorDTOS(cinemaCreateDTO);
        if (!errorDTOS.isEmpty()) {
            return ResponseDTO.<Cinema>builder()
                    .code(-1)
                    .message("Cinema validation error")
                    .errors(errorDTOS)
                    .build();
        }

        Cinema cinema = cinemaMapper.toEntity(cinemaCreateDTO);
        cinema.setCreatedAt(LocalDateTime.now());
        cinemaRepository.save(cinema);

        return ResponseDTO.<Cinema>builder()
                .code(200)
                .success(true)
                .message("Successfully saved")
                .data(cinema)
                .build();
    }

    @Override
    public ResponseDTO<Cinema> getCinema(Integer id) {
        Cinema cinema = cinemaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cinema not found: " + id));
        return ResponseDTO.<Cinema>builder()
                .code(200)
                .success(true)
                .message("Cinema found")
                .data(cinema)
                .build();
    }

    @Override
    public ResponseDTO<List<Cinema>> getAllCinema() {
        List<Cinema> cinemas = cinemaRepository.findAll();
        return ResponseDTO.<List<Cinema>>builder()
                .code(200)
                .success(true)
                .message("Cinema found")
                .data(cinemas)
                .build();
    }

    @Override
    public ResponseDTO<Cinema> updateCinema(@NotNull CinemaCreateDTO cinemaCreateDTO,
                                            @NotNull Integer cinemaId) {
        List<ErrorDTO> errorDTOS = cinemaValidation.errorDTOS(cinemaCreateDTO);
        if (!errorDTOS.isEmpty()) {
            return ResponseDTO.<Cinema>builder()
                    .code(-1)
                    .message("Cinema validation error")
                    .errors(errorDTOS)
                    .build();
        }

        Cinema cinema = cinemaRepository.findById(cinemaId)
                .orElseThrow(() -> new RuntimeException("Cinema not found: " + cinemaId));
        cinema.setName(cinemaCreateDTO.getName());
        cinema.setAddress(cinemaCreateDTO.getAddress());
        cinema.setPhone(cinemaCreateDTO.getPhone());
        cinema.setUpdatedAt(LocalDateTime.now());
        cinemaRepository.save(cinema);

        return ResponseDTO.<Cinema>builder()
                .code(200)
                .success(true)
                .message("Successfully updated")
                .data(cinema)
                .build();
    }
}

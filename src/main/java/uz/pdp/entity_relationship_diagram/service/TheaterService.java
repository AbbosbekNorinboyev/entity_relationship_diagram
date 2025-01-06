package uz.pdp.entity_relationship_diagram.service;

import org.springframework.lang.NonNull;
import uz.pdp.entity_relationship_diagram.dto.ResponseDTO;
import uz.pdp.entity_relationship_diagram.dto.TheaterCreateDTO;
import uz.pdp.entity_relationship_diagram.entity.Theater;

import java.util.List;

public interface TheaterService {
    ResponseDTO<Theater> createTheater(@NonNull TheaterCreateDTO theaterCreateDTO,
                                       @NonNull Integer cinemaId);

    ResponseDTO<Theater> getTheater(@NonNull Integer id);

    ResponseDTO<List<Theater>> getAllTheater();

    ResponseDTO<Theater> updateTheater(@NonNull TheaterCreateDTO theaterCreateDTO,
                                       @NonNull Integer theaterId,
                                       @NonNull Integer cinemaId);

}

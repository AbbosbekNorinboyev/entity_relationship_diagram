package uz.pdp.entity_relationship_diagram.service;

import org.springframework.lang.NonNull;
import uz.pdp.entity_relationship_diagram.dto.ResponseDTO;
import uz.pdp.entity_relationship_diagram.dto.ShowingCreateDTO;
import uz.pdp.entity_relationship_diagram.entity.Showing;

import java.util.List;

public interface ShowingService {
    ResponseDTO<Showing> createShowing(@NonNull ShowingCreateDTO showingCreateDTO,
                                       @NonNull Integer theaterId,
                                       @NonNull Integer movieId);

    ResponseDTO<Showing> getShowing(@NonNull Integer id);

    ResponseDTO<List<Showing>> getAllShowing();

    ResponseDTO<Showing> updateShowing(@NonNull ShowingCreateDTO showingCreateDTO,
                                       @NonNull Integer showingId,
                                       @NonNull Integer theaterId,
                                       @NonNull Integer movieId);
}

package bg.tu_varna.sit.library_training.service.interfaces;

import bg.tu_varna.sit.library_training.dto.response.GenreResponse;

public interface GenreService {
    GenreResponse addGenre(String request);
    Boolean genreExists(String request);
}

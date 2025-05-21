package bg.tu_varna.sit.library_training.service.interfaces;

import bg.tu_varna.sit.library_training.dto.request.AuthorRequest;
import bg.tu_varna.sit.library_training.dto.response.AuthorResponse;

public interface AuthorService {
    AuthorResponse addAuthor(AuthorRequest request);
    boolean authorExists(AuthorRequest request);
}

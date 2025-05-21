package bg.tu_varna.sit.library_training.service.interfaces;

import bg.tu_varna.sit.library_training.ResourceNotFound;
import bg.tu_varna.sit.library_training.dto.request.AuthorRequest;
import bg.tu_varna.sit.library_training.dto.request.GenreRequest;
import bg.tu_varna.sit.library_training.dto.response.AuthorResponse;
import bg.tu_varna.sit.library_training.dto.response.BookResponse;
import bg.tu_varna.sit.library_training.dto.request.BookRequest;
import bg.tu_varna.sit.library_training.dto.response.GenreResponse;

import java.util.List;
import java.util.Set;

public interface BookService {
    BookResponse addBook(BookRequest request) throws ResourceNotFound;
    List<BookResponse> getBooksByGenre(String genre);
    boolean checkGenre(String genreName);
    GenreResponse addGenre(GenreRequest request);
    boolean checkAuthor(String authorName);
    AuthorResponse addAuthor(AuthorRequest request);
}
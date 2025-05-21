package bg.tu_varna.sit.library_training.service.implementations;

import bg.tu_varna.sit.library_training.ResourceNotFound;
import bg.tu_varna.sit.library_training.dto.request.AuthorRequest;
import bg.tu_varna.sit.library_training.dto.request.GenreRequest;
import bg.tu_varna.sit.library_training.dto.response.AuthorResponse;
import bg.tu_varna.sit.library_training.dto.response.BookResponse;
import bg.tu_varna.sit.library_training.dto.request.BookRequest;
import bg.tu_varna.sit.library_training.dto.response.GenreResponse;
import bg.tu_varna.sit.library_training.entity.Author;
import bg.tu_varna.sit.library_training.entity.Book;
import bg.tu_varna.sit.library_training.entity.Genre;
import bg.tu_varna.sit.library_training.repository.AuthorRepository;
import bg.tu_varna.sit.library_training.repository.BookRepository;
import bg.tu_varna.sit.library_training.repository.GenreRepository;
import bg.tu_varna.sit.library_training.service.interfaces.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;
    private final AuthorRepository authorRepository;
    private final ModelMapper mapper;

    public BookServiceImpl(BookRepository bookRepository, GenreRepository genreRepository,
                           AuthorRepository authorRepository, ModelMapper mapper) {
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
        this.authorRepository = authorRepository;
        this.mapper = mapper;
    }

    @Override
    public BookResponse addBook(BookRequest request) throws ResourceNotFound {
        Genre genre = genreRepository.findByGenreIgnoreCase(request.getGenre().getGenre());
        Set<String> authorNames = request.getAuthors()
                .stream()
                .map(AuthorRequest::getName)
                .collect(Collectors.toSet());

        Book book = mapper.map(request, Book.class);
        book.setGenre(genre);
        book.setAuthors(
                authorRepository.findAllByNameInIgnoreCase(authorNames).orElseThrow(() -> new ResourceNotFound( "test" ,Book.class))
        );
        book = bookRepository.save(book);


        return mapper.map(book, BookResponse.class);
    }
    @Override
    public boolean checkGenre(String genreName) {
       return genreRepository.existsByGenreIgnoreCase(genreName);
    }

    @Override
    public boolean checkAuthor(String authorName) {
        return authorRepository.existsByName(authorName);
    }

    @Override
    public GenreResponse addGenre(GenreRequest request) {
        Genre genre = mapper.map(request, Genre.class);
        genre = genreRepository.save(genre);
        return mapper.map(genre, GenreResponse.class);
    }

    @Override
    public AuthorResponse addAuthor(AuthorRequest request) {
        Author author = mapper.map(request, Author.class);
        author = authorRepository.save(author);
        return mapper.map(author, AuthorResponse.class);
    }

    @Override
    public List<BookResponse> getBooksByGenre(String genre) {
        return bookRepository.findAllByGenre_GenreIgnoreCase(genre)
                .stream()
                .map(book -> mapper.map(book, BookResponse.class))
                .collect(Collectors.toList());
    }
}
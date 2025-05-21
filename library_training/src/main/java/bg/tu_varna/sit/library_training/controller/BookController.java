package bg.tu_varna.sit.library_training.controller;

import bg.tu_varna.sit.library_training.ResourceNotFound;
import bg.tu_varna.sit.library_training.dto.request.AuthorRequest;
import bg.tu_varna.sit.library_training.dto.request.BookRequest;
import bg.tu_varna.sit.library_training.dto.response.BookResponse;
import bg.tu_varna.sit.library_training.service.interfaces.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@Validated
@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/add")
    public ResponseEntity<BookResponse> addBook(
            @Valid @RequestBody BookRequest request
    ) throws ResourceNotFound {
        if(!bookService.checkGenre(request.getGenre().getGenre()))
            bookService.addGenre(request.getGenre());
        for(AuthorRequest author : request.getAuthors()){
            if(!bookService.checkAuthor(author.getName()))
                bookService.addAuthor(author);
        }

        BookResponse response = bookService.addBook(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }



    @GetMapping("/genre/{genreName}")
    public ResponseEntity<?> getBooksByGenre(@PathVariable String genreName) {
        List<BookResponse> books = bookService.getBooksByGenre(genreName);

        if (books.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Каталога не съдържа книги от жанр " + genreName);
        }

        return ResponseEntity.ok(books);
    }
}

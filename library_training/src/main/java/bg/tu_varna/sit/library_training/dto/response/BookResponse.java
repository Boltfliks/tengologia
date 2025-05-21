package bg.tu_varna.sit.library_training.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {
    private Long id;
    private String title;
    private int publishedYear;
    private GenreResponse genre;
    private Set<AuthorResponse> authors;
}

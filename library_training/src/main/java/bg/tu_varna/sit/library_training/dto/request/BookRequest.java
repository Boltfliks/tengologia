package bg.tu_varna.sit.library_training.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {
    @NotBlank(message = "don't leave title blank")
    private String title;

    @Min(1)
    private int publishedYear;

    @Valid
    private GenreRequest genre;

    @Valid
    private Set<AuthorRequest> authors;
}

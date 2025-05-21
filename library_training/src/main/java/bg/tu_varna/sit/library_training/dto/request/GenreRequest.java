package bg.tu_varna.sit.library_training.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GenreRequest {
    @NotBlank(message = "Genre cannot be blank")
    @Size(min = 5 , max = 30)
    private String genre;
}

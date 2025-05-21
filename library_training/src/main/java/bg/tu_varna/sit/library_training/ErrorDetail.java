package bg.tu_varna.sit.library_training;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class ErrorDetail {
    private LocalDateTime time;
    private String message;
}

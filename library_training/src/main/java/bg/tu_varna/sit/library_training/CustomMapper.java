package bg.tu_varna.sit.library_training;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Component;
/**
 * Добавено в лабораторно упражнение 9
 */
@Component
public class CustomMapper extends ModelMapper {
    public CustomMapper() {
        this.getConfiguration()
                .setSkipNullEnabled(true)
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }
}


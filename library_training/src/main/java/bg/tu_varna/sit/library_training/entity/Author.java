package bg.tu_varna.sit.library_training.entity;

import jakarta.persistence.*;
import lombok.Setter;

import java.util.Set;

@Setter
@Entity
@Table(name = "authors")
public class Author {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}

package bg.tu_varna.sit.library_training.repository;

import bg.tu_varna.sit.library_training.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    boolean existsByGenreIgnoreCase(String genre);
    Genre findByGenreIgnoreCase(String genre);
}

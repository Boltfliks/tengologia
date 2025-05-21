package bg.tu_varna.sit.library_training.repository;

import bg.tu_varna.sit.library_training.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByGenre_GenreIgnoreCase(String genre);
}

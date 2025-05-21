package bg.tu_varna.sit.library_training.repository;

import bg.tu_varna.sit.library_training.dto.request.AuthorRequest;
import bg.tu_varna.sit.library_training.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Boolean existsByName(String name);
    Optional<Set<Author>> findAllByNameInIgnoreCase(Set<String> names);

}

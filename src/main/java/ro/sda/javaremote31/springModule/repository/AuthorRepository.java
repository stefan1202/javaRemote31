package ro.sda.javaremote31.springModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.javaremote31.springModule.entities.Author;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}

package ro.sda.javaremote31.springModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.javaremote31.springModule.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {



}

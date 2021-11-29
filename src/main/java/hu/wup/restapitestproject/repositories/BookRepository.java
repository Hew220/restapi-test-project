package hu.wup.restapitestproject.repositories;

import hu.wup.restapitestproject.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}

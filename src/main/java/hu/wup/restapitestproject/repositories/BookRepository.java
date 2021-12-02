package hu.wup.restapitestproject.repositories;

import hu.wup.restapitestproject.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}

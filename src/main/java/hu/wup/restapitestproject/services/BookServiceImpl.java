package hu.wup.restapitestproject.services;

import hu.wup.restapitestproject.model.Book;
import hu.wup.restapitestproject.repositories.BookRepository;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(long id) {
        Optional<Book> result = bookRepository.findById(id);
        Book book;
        if(result.isPresent()) {
            book = result.get();
        }else {
            throw new RuntimeException("Book hasn't been found by this id: " + id);
        }
        return book;

    }

    @Override
    public void insertBook(Book book) {
        bookRepository.save(book);

    }

    @Override
    public void deleteBook(long bookId) {
        boolean exists = bookRepository.existsById(bookId);
        if (!exists) {
            throw new IllegalStateException("Book with this id " + bookId + "does not exist.");
        }
        bookRepository.deleteById(bookId);
    }

    @Override
    public void updateBook(long bookId, String title, String author) {

        Book existingBook = bookRepository.findById(bookId).orElseThrow(
                () -> new IllegalStateException("Book with this id " + bookId + " does not exist!"));
        existingBook.setTitle(title);
        existingBook.setAuthor(author);
        bookRepository.save(existingBook);
    }
}

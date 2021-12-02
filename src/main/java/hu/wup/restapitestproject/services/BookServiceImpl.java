package hu.wup.restapitestproject.services;

import hu.wup.restapitestproject.exceptions.BookNotFoundException;
import hu.wup.restapitestproject.model.Book;
import hu.wup.restapitestproject.repositories.BookRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private static final Logger logger = LogManager.getLogger(BookServiceImpl.class);

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(long id) throws BookNotFoundException  {
        Optional<Book> result = bookRepository.findById(id);
        Book book = null;
        if(result.isPresent()) {
            book = result.get();
        }else {
            logger.error("Book hasn't been found by this id:" + id);
            //throw new BookNotFoundException("Book hasn't been found by this id: " + id);
        }
        logger.debug(result.get());
        return book;

    }

    @Override
    public void insertBook(Book book) {
        bookRepository.save(book);

    }

    @Override
    public void deleteBook(long bookId) {
        boolean exists = bookRepository.existsById(bookId);
        logger.debug("deleteBook by: " + bookId);
        if (!exists) {
            throw new IllegalStateException("Book with this id " + bookId + "does not exist.");
        }
        bookRepository.deleteById(bookId);
    }

    @Override
    public void updateBook(long bookId, Book book) {

        Book existingBook = bookRepository.findById(bookId).orElseThrow(
                () -> new IllegalStateException("Book with this id " + bookId + " does not exist!"));
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        bookRepository.save(existingBook);
    }





}

package hu.wup.restapitestproject.services;

import hu.wup.restapitestproject.exceptions.BookNotFoundException;
import hu.wup.restapitestproject.model.Book;

import java.util.Optional;

public interface BookService {

    Iterable<Book> getAllBooks();

    Book getBookById(long id) throws BookNotFoundException;

    void insertBook(Book book);

    void deleteBook(long id);

    void updateBook(long id, Book book);





}

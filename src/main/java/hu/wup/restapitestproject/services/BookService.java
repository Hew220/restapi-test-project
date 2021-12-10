package hu.wup.restapitestproject.services;

import hu.wup.restapitestproject.model.Book;

public interface BookService {

    Iterable<Book> getAllBooks();

    Book getBookById(long id);

    Book getBookByTitle(String title);

    void insertBook(Book book);

    void deleteBook(long id);

    void updateBook(long id, Book book);





}

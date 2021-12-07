package hu.wup.restapitestproject.controllers;

import hu.wup.restapitestproject.exceptions.ApiRequestException;
import hu.wup.restapitestproject.model.Book;
import hu.wup.restapitestproject.services.BookService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/")
public class BookController {

    private final BookService bookService;
    private static final Logger logger = LogManager.getLogger(BookController.class);

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/bookstore")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/getBook/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable long bookId) {
        Book book = bookService.getBookById(bookId);
        logger.debug("Book id: " + book.getId());
        return new ResponseEntity<>(book, HttpStatus.OK);

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Book> addNewBook(@RequestBody Book book) {

        //logger.info("addNewBook " + book.toString());
        bookService.insertBook(book);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping(path= "/all")
    public @ResponseBody Iterable<Book> getAllUser() {
        return bookService.getAllBooks();
    }

    @DeleteMapping(path = "/delete/{bookId}")
    public @ResponseBody ResponseEntity<Book> deleteBook(@PathVariable("bookId") long bookId) {
        bookService.deleteBook(bookId);
        return new ResponseEntity<>(new Book(bookId), HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/update/{bookId}")
    public @ResponseBody ResponseEntity<Book> updateBook(@PathVariable("bookId") long bookId,@RequestBody Book book){
        bookService.updateBook(bookId,book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);

    }



}

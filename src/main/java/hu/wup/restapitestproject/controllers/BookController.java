package hu.wup.restapitestproject.controllers;

import hu.wup.restapitestproject.model.Book;
import hu.wup.restapitestproject.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/")
    public String viewHomePage() {
        return "index";
    }

    @PostMapping(path = "/add")
    public @ResponseBody String addNewBook(@RequestParam String author, @RequestParam String title) {

        Book book = new Book();
        book.setAuthor(author);
        book.setTitle(title);
        bookService.insertBook(book);
        return "Saved";

    }

    @GetMapping(path= "/all")
    public @ResponseBody Iterable<Book> getAllUser() {
        return bookService.getAllBooks();
    }

    @DeleteMapping(path = "{bookId}")
    public @ResponseBody String deleteBook(@PathVariable("bookId") long bookId) {
        bookService.deleteBook(bookId);
        return "Deleted";
    }

    @PutMapping(path = "{bookId}")
    public @ResponseBody String updateBook(@PathVariable("bookId") long bookId,
                           @RequestParam() String title,
                           @RequestParam() String author){
        bookService.updateBook(bookId, title, author);
        return "Updated";
    }



}

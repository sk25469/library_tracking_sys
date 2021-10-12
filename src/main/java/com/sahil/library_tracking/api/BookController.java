package com.sahil.library_tracking.api;

import com.sahil.library_tracking.service.BookService;
import com.sahil.library_tracking.model.Book;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/book")
@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public void insertBook(@RequestBody Book book) {
        bookService.insertBook(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBook();
    }

    @GetMapping(path = "subject/{sub}")
    public List<Book> getAllBooksBySubject(@PathVariable("sub") String subject) {
        return bookService.getAllBooksBySubject(subject);
    }

    @GetMapping(path = "{id}")
    public Book getBookById(@PathVariable("id") UUID id) {
        return bookService.getBookById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public int deleteBookById(@PathVariable("id") UUID id) {
        return bookService.deleteBookById(id);
    }

    @PutMapping(path = "{id}")
    public int updateBookById(@PathVariable("id") UUID id) {
        return bookService.updateBookById(id);
    }

}
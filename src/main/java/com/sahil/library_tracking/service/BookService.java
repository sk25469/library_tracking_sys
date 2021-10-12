package com.sahil.library_tracking.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.sahil.library_tracking.dao.BookDao;
import com.sahil.library_tracking.model.Book;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {

    private final BookDao bookDao;

    public BookService(@Qualifier("postgres") BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public int insertBook(Book book) {
        return bookDao.insertBook(book);
    }

    public List<Book> getAllBook() {
        return bookDao.getAllBook();
    }

    public List<Book> getAllBooksBySubject(String subject) {
        return bookDao.getAllBooksBySubject(subject);
    }

    public Optional<Book> getBookById(UUID id) {
        return bookDao.selectBookById(id);
    }

    public int deleteBookById(UUID id) {
        return bookDao.deleteBookById(id);
    }

    public int updateBookById(UUID id, Book newBook) {
        return bookDao.updateBookById(id, newBook);
    }
}
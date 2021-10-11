package com.sahil.library_tracking.dao;

import java.util.List;
import java.util.UUID;
import com.sahil.library_tracking.model.Book;
import java.util.Optional;

public interface BookDao {

    int insertBook(UUID id, Book book);

    default int insertBook(Book book) {
        UUID id = UUID.randomUUID();
        return insertBook(id, book);
    }

    int deleteBookById(UUID id);

    List<Book> getAllBook();

    Optional<Book> selectBookById(UUID id);

    int updateBookById(UUID id, Book newBook);

}
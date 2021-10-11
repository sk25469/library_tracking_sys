package com.sahil.library_tracking.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.sahil.library_tracking.model.Book;

public class BookDataAccessService implements BookDao {

    @Override
    public int insertBook(UUID id, Book book) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int deleteBookById(UUID id) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Book> getAllBook() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Book> selectBookById(UUID id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int updateBookById(UUID id, Book newBook) {
        // TODO Auto-generated method stub
        return 0;
    }

}

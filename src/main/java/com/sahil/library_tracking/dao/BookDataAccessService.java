package com.sahil.library_tracking.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.sahil.library_tracking.model.Book;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("postgres")
public class BookDataAccessService implements BookDao {

    private final JdbcTemplate jdbcTemplate;

    public BookDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertBook(UUID id, Book book) {
        String sql = "INSERT INTO books(id,name,subject,cnt,location) VALUES(?,?,?,?,?)";
        int rowsAffected = jdbcTemplate.update(sql, id, book.getName(), book.getSubject(), book.getAvailCnt(),
                book.getLocation());
        if (rowsAffected > 0)
            return 1;
        return 0;
    }

    @Override
    public int deleteBookById(UUID id) {
        final String sql = "DELETE FROM books WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql, id);
        if (rowsAffected > 0)
            return 1;
        return 0;
    }

    @Override
    public List<Book> getAllBook() {
        final String sql = "SELECT id, name, subject, cnt, location FROM books";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String subject = resultSet.getString("subject");
            int cnt = resultSet.getInt("cnt");
            String location = resultSet.getString("location");
            return new Book(id, name, subject, location, cnt);
        });
    }

    @Override
    public Optional<Book> selectBookById(UUID id) {
        final String sql = "SELECT id, name, subject, cnt, location FROM books WHERE id = ?";
        Book book = jdbcTemplate.queryForObject(sql, (resultSet, i) -> {
            UUID bookId = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String subject = resultSet.getString("subject");
            int cnt = resultSet.getInt("cnt");
            String location = resultSet.getString("location");
            return new Book(bookId, name, subject, location, cnt);
        }, id);
        return Optional.ofNullable(book);
    }

    @Override
    public int updateBookById(UUID id) {
        String sql = "SELECT cnt FROM books where id = ?";
        int initialCnt = jdbcTemplate.queryForObject(sql, (resultSet, i) -> {
            return resultSet.getInt("cnt");
        });
        sql = "UPDATE books SET cnt = ? WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql, initialCnt - 1, id);
        if (rowsAffected > 0)
            return 1;
        return 0;
    }

    @Override
    public List<Book> getAllBooksBySubject(String subject) {
        final String sql = "SELECT id, name, subject, cnt, location FROM books WHERE subject = ?";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            // String subject = resultSet.getString("subject");
            int cnt = resultSet.getInt("cnt");
            String location = resultSet.getString("location");
            return new Book(id, name, subject, location, cnt);
        }, subject);
    }

}

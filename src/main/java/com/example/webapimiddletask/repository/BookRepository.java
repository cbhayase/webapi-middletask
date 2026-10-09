package com.example.webapimiddletask.repository;

import com.example.webapimiddletask.dto.Book;
import com.example.webapimiddletask.mapper.BookMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {
    private final BookMapper bookMapper;

    public BookRepository(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public List<Book> findAll() {
        return bookMapper.findAll();
    }
}

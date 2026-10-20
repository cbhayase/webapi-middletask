package com.example.webapimiddletask.service;

import com.example.webapimiddletask.dto.Book;
import com.example.webapimiddletask.exception.BookArgumentNotValidException;
import com.example.webapimiddletask.exception.BookNotFoundException;
import com.example.webapimiddletask.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book saveBook(Book book) {
        if (book.getTitle() == null || book.getTitle().isEmpty()) {
            throw new BookArgumentNotValidException("title is empty");
        }

        if (book.getAuthor() == null || book.getAuthor().isEmpty()) {
            throw new BookArgumentNotValidException("author is empty");
        }

        if (book.getGenre() == null || book.getGenre().isEmpty()) {
            throw new BookArgumentNotValidException("genre is empty");
        }

        if (book.getPublishedYear() <= 0) {
            throw new BookArgumentNotValidException("publishedYear is invalid");
        }

        bookRepository.insertBook(book);
        return book;
    }

    public Book findById(long id) {
        Book book = bookRepository.findById(id);

        if (book == null) {
            throw new BookNotFoundException(id);
        }

        return book;
    }

    public boolean delete(long id) {
        if (!bookRepository.delete(id)) {
            throw new BookNotFoundException(id);
        }
        return true;
    }

    public Book update(Book book, long id) {
        if (book.getTitle() == null || book.getTitle().isEmpty()) {
            throw new BookArgumentNotValidException("title is empty");
        }

        if (book.getAuthor() == null || book.getAuthor().isEmpty()) {
            throw new BookArgumentNotValidException("author is empty");
        }

        if (book.getGenre() == null || book.getGenre().isEmpty()) {
            throw new BookArgumentNotValidException("genre is empty");
        }

        if (book.getPublishedYear() <= 0) {
            throw new BookArgumentNotValidException("publishedYear is invalid");
        }

        Book targetBook = bookRepository.findById(id);
        if (targetBook == null) {
            throw new BookNotFoundException(id);
        }

        book.setId(id);
        return bookRepository.update(book);
    }
}
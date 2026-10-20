package com.example.webapimiddletask.controller;

import com.example.webapimiddletask.dto.Book;
import com.example.webapimiddletask.service.BookService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> findAllBooks() {
        List<Book> books = bookService.findAll();

        //return new ResponseEntity<>(books, HttpStatus.OK);

        return  ResponseEntity.ok(books);
    }

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody Book book, UriComponentsBuilder uriBuilder) {
        Book createdBook = bookService.saveBook(book);

        URI location = uriBuilder.path("/api/books/{id}").buildAndExpand(createdBook.getId()).toUri();

        //HttpHeaders headers = new HttpHeaders();
        //headers.setLocation(location);

        //return new ResponseEntity<>(createdBook, headers, HttpStatus.CREATED);

        return ResponseEntity.created(location).body(createdBook);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable long id) {
        Book book = bookService.findById(id);

        return  ResponseEntity.ok(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        bookService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable long id, @RequestBody Book book) {
        bookService.update(book, id);
        return ResponseEntity.ok(book);
    }
}

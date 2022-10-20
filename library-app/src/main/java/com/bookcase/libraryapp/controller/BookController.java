package com.bookcase.libraryapp.controller;

import com.bookcase.libraryapp.exception.BookNotFoundException;
import com.bookcase.libraryapp.model.Book;
import com.bookcase.libraryapp.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    /*
    -> A couple problems with this:
    1. If the repository constructor ever changes, everytime we create a new instance, we may have to go update it.
    2. If we try to write tests for this, it's going to be a problem if the repository class is talking to a database.
    BookRepository repository;
    public BookController() {
        repository = new BookRepository();
    }

    -> WE DON'T manage data in a controller
    private List<Book> books = new ArrayList<>();
    public BookController() {
        books.add(new Book());
    }
     */

    // GET http://localhost:8080/books
    @GetMapping
    public List<Book> findAll() {
        return repository.findAll();
    }

    // GET http://localhost:8080/books/1441-213-2412-412 etc.
    @GetMapping("/{id}")
    public Book findById(@PathVariable String id) throws BookNotFoundException {
        return repository.findById(id);
    }

    // POST http://localhost:8080/books
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Book create(@Valid @RequestBody Book book) {
        return repository.create(book);
    }

    // PUT http://localhost:8080/books/1441-213-2412-412 etc.
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Book book, @PathVariable String id) {
        repository.update(book, id);
    }

    // DELETE http://localhost:8080/books/1441-213-2412-412 etc.
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repository.delete(id);
    }
}

package com.bookcase.libraryapp.service;

import com.bookcase.libraryapp.exception.BookNotFoundException;
import com.bookcase.libraryapp.model.Book;
import com.bookcase.libraryapp.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    private final BookRepo repository;

    @Autowired
    public BookService(BookRepo repository) {
        this.repository = repository;
    }

    public List<Book> findAllBooks() {
        return repository.findAll();
    }

    public Book findBookById(Long id) {
        return repository.findBookById(id).orElseThrow(
                () -> new BookNotFoundException("Book by id " + id + "is not found."));
    }

    public Book addBook(Book book) {
        book.setBookCode(UUID.randomUUID().toString());
        return repository.save(book);
    }

    public Book updateBook(Book book) {
        return repository.save(book);
    }

    public void deleteBook(Long id) {
        repository.deleteBookById(id);
    }
}

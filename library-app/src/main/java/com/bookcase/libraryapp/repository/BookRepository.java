package com.bookcase.libraryapp.repository;

import com.bookcase.libraryapp.exception.BookNotFoundException;
import com.bookcase.libraryapp.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class BookRepository {

    List<Book> books = new ArrayList<>();

    public BookRepository() {
        books.add( new Book(
                UUID.randomUUID().toString(),
                "Old Man's War",
                "John Scalzi",
                "Tor Books",
                2005,
                "Old Man's War is about a soldier named John Perry and his exploits in the Colonial Defense" +
                        "Forces (CDF). The recruit to the rank of captain. It is set in a universe heavily populated with life" +
                        "forms, and human colonists must compete for the scarce planets that are suitable for sustaining life." +
                        "As a result, Perry must learn to fight a wide variety of aliens. The characters in Old Man's War have" +
                        "enhanced DNA and nanotechnology, giving them advantages in strength, speed, endurance, and situational" +
                        "awareness.",
                320, 0
        ));
    }

    public List<Book> findAll() {
        return books;
    }

    public Book findById(String id) throws BookNotFoundException {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst().orElseThrow(BookNotFoundException::new);
    }

    public Book create(Book book) {
        books.add(book);
        return book;
    }

    public void update(Book book, String id) {
        Book existing = books.stream().filter(b -> b.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));
        int i = books.indexOf(existing);
        books.set(i, book);
    }

    public void delete(String id) {
        books.removeIf(book -> book.getId().equals(id));
    }
}

package com.bookcase.libraryapp.repository;

import com.bookcase.libraryapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepo extends JpaRepository<Book, Long> {

    void deleteBookById(Long id);
    Optional<Book> findBookById(Long id); //return type is optional as the book with the specified id may not exist

}

package com.example.demo.repository;

import com.example.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BooksRepository extends JpaRepository<Book, Long> {


    @Query("select s from Book s where s.name = ?1")
    Optional<Book> findBookByName(String name);
}

package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BooksRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class BookService {
    private BooksRepository booksRepository;


    public BookService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Book>getBooks(){
        return booksRepository.findAll();
    }

    public void addNewBook(Book book){
        Optional<Book> booksByName = booksRepository.findBookByName(book.getName());

        if (booksByName.isPresent()){
            throw new IllegalStateException("book already exist");
        }
        booksRepository.save(book);
    }

    public void deleteBook(Long id){
        boolean exist = booksRepository.existsById(id);

        if(!exist){
            throw new IllegalStateException("book with id = " + id + " not found");
        }

        booksRepository.deleteById(id);
    }
}

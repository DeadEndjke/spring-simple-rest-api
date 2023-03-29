package com.example.demo.config;


import com.example.demo.entity.Book;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
            Book book1 = new Book(
              "bookname1",
              45
            );
            Book book2 = new Book(
                    "bookname2",
                    1231
            );
            Book book3 = new Book(
                    "bookname32",
                    5434
            );
            User user1 = new User(
                    "Name1",
                    22,
                    "name@mail.ru",
                    List.of(book1, book2)
            );
            User user2 = new User(
                    "Name2",
                    23,
                    "name23@mail.ru",
                    List.of(book3)
            );
            repository.saveAll(List.of(user1, user2));
        };
    }
}

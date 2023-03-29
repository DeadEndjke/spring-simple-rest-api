package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void addNewUser(User user) {
        Optional<User> userByEmail = userRepository.findUserByEmail(user.getEmail());
        if (userByEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        boolean exist = userRepository.existsById(id);

        if(!exist){
            throw new IllegalStateException("user with id = " + id + " not found");
        }

        userRepository.deleteById(id);

    }
}

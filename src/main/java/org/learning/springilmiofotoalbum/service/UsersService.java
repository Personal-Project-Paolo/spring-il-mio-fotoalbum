package org.learning.springilmiofotoalbum.service;

import org.learning.springilmiofotoalbum.exception.PhotoNotFoundException;
import org.learning.springilmiofotoalbum.model.Photo;
import org.learning.springilmiofotoalbum.model.User;
import org.learning.springilmiofotoalbum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
     private UserRepository userRepository;

    public List<User> getUserList() {
        return userRepository.findAll();
    }
}

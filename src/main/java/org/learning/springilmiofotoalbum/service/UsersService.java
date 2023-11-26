package org.learning.springilmiofotoalbum.service;

import org.learning.springilmiofotoalbum.model.Photo;
import org.learning.springilmiofotoalbum.model.User;
import org.learning.springilmiofotoalbum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
     private UserRepository userRepository;

    public List<User> getUserList() {
        return userRepository.findAll();
    }
}

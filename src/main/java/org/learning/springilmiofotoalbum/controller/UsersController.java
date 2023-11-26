package org.learning.springilmiofotoalbum.controller;

import org.learning.springilmiofotoalbum.model.User;
import org.learning.springilmiofotoalbum.repository.UserRepository;
import org.learning.springilmiofotoalbum.security.DatabaseUserDetails;
import org.learning.springilmiofotoalbum.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
     private UserRepository userRepository;

    @Autowired
     private UsersService usersService;

    @GetMapping
    public String index (Authentication authentication, Model model){
        DatabaseUserDetails principal = (DatabaseUserDetails) authentication.getPrincipal();
        User loggedUser = userRepository.findById(principal.getId()).get();
        model.addAttribute(loggedUser.getFirstName());
        model.addAttribute(loggedUser.getLastName());

        model.addAttribute("usersList", usersService.getUserList());

        return "/users/list";
    }
}

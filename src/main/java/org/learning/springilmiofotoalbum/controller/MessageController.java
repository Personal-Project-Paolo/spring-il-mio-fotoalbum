package org.learning.springilmiofotoalbum.controller;

import org.learning.springilmiofotoalbum.exception.MessageNotFoundException;
import org.learning.springilmiofotoalbum.model.Message;
import org.learning.springilmiofotoalbum.model.User;
import org.learning.springilmiofotoalbum.repository.UserRepository;
import org.learning.springilmiofotoalbum.security.DatabaseUserDetails;
import org.learning.springilmiofotoalbum.service.MessageService;
import org.learning.springilmiofotoalbum.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UsersService usersService;

    @GetMapping
    public String index (Authentication authentication, Model model){
        DatabaseUserDetails principal = (DatabaseUserDetails) authentication.getPrincipal();
        DatabaseUserDetails user = (DatabaseUserDetails) authentication.getPrincipal();
        User loggedUser = userRepository.findById(principal.getId()).orElse(null);

        if (loggedUser != null) {
            model.addAttribute("firstName", loggedUser.getFirstName());
            model.addAttribute("lastName", loggedUser.getLastName());
        }

        model.addAttribute("messageList", messageService.geMessageListByAdmin(user.getId()));
        return "/messages/list";
    }

    @GetMapping("/show/{id}")
    public String show (@PathVariable Integer id, Model model){
        try{
            Message message = messageService.getMessageById(id);
            model.addAttribute("message", message);
            return "messages/show";
        }catch (MessageNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        try{
            Message messageToDelete = messageService.getMessageById(id);
            messageService.deleteMessage(id);
            redirectAttributes.addFlashAttribute(
                    "message",
                    "Message deleted!"
            );
            return "redirect:/messages";
        }catch (MessageNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}

package org.learning.springilmiofotoalbum.api;


import jakarta.validation.Valid;
import org.learning.springilmiofotoalbum.model.Message;
import org.learning.springilmiofotoalbum.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/messages")
@CrossOrigin
public class MessageRestController {

    @Autowired
    MessageService messageService;

    @PostMapping
    public Message create(@Valid @RequestBody Message message){
        return messageService.createMessage(message);
    }

}

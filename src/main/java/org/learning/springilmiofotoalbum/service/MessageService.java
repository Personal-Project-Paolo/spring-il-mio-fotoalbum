package org.learning.springilmiofotoalbum.service;


import org.learning.springilmiofotoalbum.model.Message;
import org.learning.springilmiofotoalbum.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    public List<Message> getMessageList() {
        return messageRepository.findAll();
    }

    public Message createMessage(Message message){
        message.setId(null);
        message.setCreatedAt(LocalDateTime.now());
        return messageRepository.save(message);
    }

}

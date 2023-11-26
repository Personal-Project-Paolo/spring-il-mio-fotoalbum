package org.learning.springilmiofotoalbum.service;


import org.learning.springilmiofotoalbum.exception.MessageNotFoundException;
import org.learning.springilmiofotoalbum.model.Message;
import org.learning.springilmiofotoalbum.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    //Index
    public List<Message> getMessageList() {
        return messageRepository.findAll();
    }

    //Show
    public Message getMessageById(Integer id) throws MessageNotFoundException {
        Optional<Message> result = messageRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "message with id " + id + " not found");
        }
    }

    //Create
    public Message createMessage(Message message){
        message.setId(null);
        message.setCreatedAt(LocalDateTime.now());
        return messageRepository.save(message);
    }

    //Delete
    public void deleteMessage (Integer id) {
        messageRepository.deleteById(id);
    }

}

package org.learning.springilmiofotoalbum.repository;


import org.learning.springilmiofotoalbum.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {

    List<Message> findByUserId(Integer userId);
}

package org.learning.springilmiofotoalbum.exception;

public class MessageNotFoundException extends RuntimeException{
    public MessageNotFoundException (String message){
        super (message);
    }
}

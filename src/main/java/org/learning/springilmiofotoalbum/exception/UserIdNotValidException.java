package org.learning.springilmiofotoalbum.exception;

public class UserIdNotValidException extends RuntimeException{
    public UserIdNotValidException(String message){
        super(message);
    }
}

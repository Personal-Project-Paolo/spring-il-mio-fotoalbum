package org.learning.springilmiofotoalbum.exception;

public class PhotoTitleUniqueException extends RuntimeException{
    public PhotoTitleUniqueException(String message){
        super(message);
    }
}

package org.learning.springilmiofotoalbum.exception;

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException (String message){
        super (message);
    }
}

package org.learning.springilmiofotoalbum.service;

import org.learning.springilmiofotoalbum.model.Category;
import org.learning.springilmiofotoalbum.model.Photo;
import org.learning.springilmiofotoalbum.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getCategoryList(Optional<String> search){
        if(search.isPresent()){
            return categoryRepository.findByNameContainingIgnoreCase(search.get());
        }
        else {
            return categoryRepository.findByOrderByName();
        }
    }
}

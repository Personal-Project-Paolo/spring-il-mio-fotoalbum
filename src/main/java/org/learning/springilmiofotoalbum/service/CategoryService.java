package org.learning.springilmiofotoalbum.service;

import org.learning.springilmiofotoalbum.exception.CategoryNameUniqueException;
import org.learning.springilmiofotoalbum.model.Category;
import org.learning.springilmiofotoalbum.model.Photo;
import org.learning.springilmiofotoalbum.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    //Index
    public List<Category> getCategoryList(Optional<String> search){
        if(search.isPresent()){
            return categoryRepository.findByNameContainingIgnoreCase(search.get());
        }
        else {
            return categoryRepository.findByOrderByName();
        }
    }

    //Show
    public Category getCategoryById(Integer id) throws CategoryNameUniqueException {
        Optional<Category> result = categoryRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "category with id " + id + " not found");
        }
    }

    //Create
    public Category save(Category category) throws CategoryNameUniqueException {
        if (categoryRepository.existsByName((category.getName()))) {
            throw new CategoryNameUniqueException(category.getName());
        }
        return categoryRepository.save(category);
    }

    //Delete
    public void deleteCategory (Integer id) {
        categoryRepository.deleteById(id);
    }
}

package org.learning.springilmiofotoalbum.repository;

import org.learning.springilmiofotoalbum.model.Category;
import org.learning.springilmiofotoalbum.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findByOrderByName();
    List<Category> findByNameContainingIgnoreCase(String nameKeyword);
    boolean existsByName(String name);
}

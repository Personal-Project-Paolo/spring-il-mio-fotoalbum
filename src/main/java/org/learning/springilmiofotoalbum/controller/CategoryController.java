package org.learning.springilmiofotoalbum.controller;

import jakarta.validation.Valid;
import org.learning.springilmiofotoalbum.exception.CategoryNameUniqueException;
import org.learning.springilmiofotoalbum.exception.CategoryNotFoundException;
import org.learning.springilmiofotoalbum.model.Category;
import org.learning.springilmiofotoalbum.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public String index (@RequestParam Optional<String> search,  Model model) {
        model.addAttribute("categoryList", categoryService.getCategoryList(search));
        model.addAttribute("categoryObj", new Category());
        return "categories/list";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute("categoryObj") Category formCategory,
                         BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("categoryList", categoryService.getCategoryList(Optional.empty()));
            return "redirect:/categories";
        }
        try {
            categoryService.save(formCategory);
            return "redirect:/categories";
        } catch (CategoryNameUniqueException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "A category with name " + e.getMessage() + " already exists");
        }
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        try{
            Category categoryToDelete = categoryService.getCategoryById(id);
            categoryService.deleteCategory(id);
            redirectAttributes.addFlashAttribute(
                    "message",
                    categoryToDelete.getName()
                            + " deleted!"
            );
            return "redirect:/categories";
        }catch (CategoryNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

}

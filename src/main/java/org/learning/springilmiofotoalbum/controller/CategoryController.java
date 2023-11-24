package org.learning.springilmiofotoalbum.controller;

import org.learning.springilmiofotoalbum.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public String index (@RequestParam Optional<String> search,  Model model) {
        model.addAttribute("categoryList", categoryService.getCategoryList(search));
       // model.addAttribute("categoryObj", new Category());
        return "categories/list";

    }
}

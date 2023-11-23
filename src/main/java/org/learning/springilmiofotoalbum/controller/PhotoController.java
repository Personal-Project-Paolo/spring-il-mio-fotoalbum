package org.learning.springilmiofotoalbum.controller;

import jakarta.validation.Valid;
import org.learning.springilmiofotoalbum.exception.PhotoTitleUniqueException;
import org.learning.springilmiofotoalbum.exception.PhotoNotFoundException;
import org.learning.springilmiofotoalbum.model.Category;
import org.learning.springilmiofotoalbum.model.Photo;
import org.learning.springilmiofotoalbum.repository.CategoryRepository;
import org.learning.springilmiofotoalbum.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/photos")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public String index(@RequestParam Optional<String> search, Model model){
        model.addAttribute("photoList", photoService.getPhotoList(search));
        return "/photos/list";
    }

    @GetMapping("/show/{id}")
    public String show(@PathVariable Integer id, Model model){
        try{
            Photo photo = photoService.getPhotoById(id);
            model.addAttribute("photo", photo);
            return "photos/show";
        }catch (PhotoNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("photo", new Photo());

        List<Category> categoryList = categoryRepository.findByOrderByName();
        model.addAttribute("categoryList", categoryList);
        return "/photos/form";

    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("photo") Photo formPhoto,
                        BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){

            List<Category> categoryList = categoryRepository.findByOrderByName();
            model.addAttribute("categoryList", categoryList);

            return "/photos/form";
        }
        try{
            formPhoto.setCreatedAt(LocalDateTime.now());
            Photo savedPhoto = photoService.createPhoto(formPhoto);
            return "redirect:/photos/show/" + savedPhoto.getId();
        }catch (PhotoTitleUniqueException e){
            bindingResult.addError(new FieldError("photo", "title", e.getMessage(),
                    false, null, null, "This Photo already exist" ));

            List<Category> categoryList = categoryRepository.findByOrderByName();
            model.addAttribute("categoryList", categoryList);
            return "/photos/form";
        }


    }


}

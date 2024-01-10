package org.learning.springilmiofotoalbum.controller;

import jakarta.validation.Valid;
import org.learning.springilmiofotoalbum.exception.PhotoTitleUniqueException;
import org.learning.springilmiofotoalbum.exception.PhotoNotFoundException;
import org.learning.springilmiofotoalbum.exception.UserIdNotValidException;
import org.learning.springilmiofotoalbum.exception.UserNotFoundException;
import org.learning.springilmiofotoalbum.model.Category;
import org.learning.springilmiofotoalbum.model.Photo;
import org.learning.springilmiofotoalbum.model.User;
import org.learning.springilmiofotoalbum.repository.CategoryRepository;
import org.learning.springilmiofotoalbum.repository.UserRepository;
import org.learning.springilmiofotoalbum.security.DatabaseUserDetails;
import org.learning.springilmiofotoalbum.service.PhotoService;
import org.learning.springilmiofotoalbum.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UsersService usersService;

    @GetMapping
    public String index (@RequestParam Optional<String> search, Model model, Authentication authentication){

        DatabaseUserDetails user = (DatabaseUserDetails) authentication.getPrincipal();
        /*System.out.println(user.getUsername());
        System.out.println(user.getAuthorities());*/

        DatabaseUserDetails principal = (DatabaseUserDetails) authentication.getPrincipal();
        User loggedUser = userRepository.findById(principal.getId()).orElse(null);

        if (loggedUser != null) {
            model.addAttribute("firstName", loggedUser.getFirstName());
            model.addAttribute("lastName", loggedUser.getLastName());
        }

        if (user.isSuperAdmin()){
            model.addAttribute("photoList", photoService.getPhotoList(search));
        }else{
            model.addAttribute("photoList", photoService.getPhotoListForAdmin(search, user.getId()));
        }
        return "/photos/list";
    }

    @GetMapping("/show/{id}")
    public String show (@PathVariable Integer id, Model model, Authentication authentication){
        DatabaseUserDetails user = (DatabaseUserDetails) authentication.getPrincipal();
        Integer photoId = photoService.getPhotoById(id).getUser().getId();
        if (user.isSuperAdmin() || user.getId().equals(photoId)) {
            try {
                Photo photo = photoService.getPhotoById(id);
                model.addAttribute("photo", photo);

                DatabaseUserDetails principal = (DatabaseUserDetails) authentication.getPrincipal();
                User loggedUser = userRepository.findById(principal.getId()).orElse(null);

                if (loggedUser != null) {
                    model.addAttribute("firstName", loggedUser.getFirstName());
                    model.addAttribute("lastName", loggedUser.getLastName());
                }

                return "photos/show";
            } catch (PhotoNotFoundException e) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
            }
        }else{
            throw new UserIdNotValidException("Cannot show other users photos");
        }
    }

    @GetMapping("/create")
    public String create (Model model, Authentication authentication){
        try{
            DatabaseUserDetails user = (DatabaseUserDetails) authentication.getPrincipal();
            model.addAttribute("photo", photoService.createPhoto(user.getId()));
            List<Category> categoryList = categoryRepository.findByOrderByName();
            model.addAttribute("categoryList", categoryList);
            return "/photos/form";
        } catch (UserNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping("/create")
    public String store (@Valid @ModelAttribute("photo") Photo formPhoto,
                        BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){

            List<Category> categoryList = categoryRepository.findByOrderByName();
            model.addAttribute("categoryList", categoryList);

            return "/photos/form";
        }
        try{
            formPhoto.setCreatedAt(LocalDateTime.now());
            Photo savedPhoto = photoService.savedPhoto(formPhoto);
            return "redirect:/photos/show/" + savedPhoto.getId();
        }catch (PhotoTitleUniqueException e){
            bindingResult.addError(new FieldError("photo", "title", e.getMessage(),
                    false, null, null, "This Photo already exist"));

            List<Category> categoryList = categoryRepository.findByOrderByName();
            model.addAttribute("categoryList", categoryList);
            return "/photos/form";
        }
    }

    @GetMapping("/edit/{id}")
    public String edit (@PathVariable Integer id, Model model, Authentication authentication) {
        DatabaseUserDetails user = (DatabaseUserDetails) authentication.getPrincipal();
        Integer photoId = photoService.getPhotoById(id).getUser().getId();
        if (user.isSuperAdmin() || user.getId().equals(photoId)){
            try{
                model.addAttribute("photo", photoService.getPhotoById(id));
                List<Category> categoryList = categoryRepository.findByOrderByName();
                model.addAttribute("categoryList", categoryList);

                return "/photos/form";
            }catch (PhotoNotFoundException e){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "photo with id " + id + " not found");
            }
        } else {
            throw new UserIdNotValidException("Cannot edit other users photos");
        }
    }

    @PostMapping("/edit/{id}")
    public String update (@PathVariable Integer id,
                          @Valid @ModelAttribute("photo") Photo formPhoto,
                          BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()){
            List<Category> categoryList = categoryRepository.findByOrderByName();
            model.addAttribute("categoryList", categoryList);
            return "/photos/form";
        }
        try{
            Photo savedPhoto = photoService.editPhoto(formPhoto);
            return "redirect:/photos/show/" + savedPhoto.getId();
        }catch (PhotoNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable Integer id, 
                         RedirectAttributes redirectAttributes, 
                         Authentication authentication){

        DatabaseUserDetails user = (DatabaseUserDetails) authentication.getPrincipal();
        Integer photoId = photoService.getPhotoById(id).getUser().getId();
        if (user.isSuperAdmin() || user.getId().equals(photoId)){
            try{
                Photo photoToDelete = photoService.getPhotoById(id);
                photoService.deletePhoto(id);
                redirectAttributes.addFlashAttribute(
                        "message",
                        photoToDelete.getTitle()
                                + " deleted!"
                );
                return "redirect:/photos";
            }catch (PhotoNotFoundException e){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
            }
        }else {
            throw new UserIdNotValidException("Cannot edit other users photos");
        }
    }


}

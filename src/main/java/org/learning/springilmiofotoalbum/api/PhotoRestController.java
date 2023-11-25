package org.learning.springilmiofotoalbum.api;

import jakarta.validation.Valid;
import org.learning.springilmiofotoalbum.exception.PhotoNotFoundException;
import org.learning.springilmiofotoalbum.exception.PhotoTitleUniqueException;
import org.learning.springilmiofotoalbum.model.Photo;
import org.learning.springilmiofotoalbum.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/photos")
@CrossOrigin
public class PhotoRestController {

    @Autowired
    private PhotoService photoService;

    //http://localhost:8080/api/v1/photos
    @GetMapping
    public List<Photo> index (@RequestParam Optional<String> search){
        return photoService.getPhotoVisibility(search);
    }

    //http://localhost:8080/api/v1/photos/id
    @GetMapping("/{id}")
    public Photo show(@PathVariable Integer id){
        try{
            return photoService.getPhotoById(id);
        }catch (PhotoNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    //http://localhost:8080/api/v1/photos
    @PostMapping
    public Photo create(@Valid @RequestBody Photo photo) {
        try {
            return photoService.createPhoto(photo);
        } catch (PhotoTitleUniqueException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    //http://localhost:8080/api/v1/photos/id
    @PutMapping("/{id}")
    public Photo update(@PathVariable Integer id, @Valid @RequestBody Photo photo) {
        photo.setId(id);
        try {
            return photoService.editPhoto(photo);
        } catch (PhotoNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    //http://localhost:8080/api/v1/photos/id
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        try {
            Photo photoToDelete = photoService.getPhotoById(id);
            photoService.deletePhoto(id);
        } catch (PhotoNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    //Paginazione
    @GetMapping("/page")
    public Page<Photo> pagedIndex(
            @RequestParam(name = "size", defaultValue = "5") Integer size,
            @RequestParam(name = "page", defaultValue = "0") Integer page) {

        return photoService.getPage(PageRequest.of(page, size));
    }

    //http://localhost:8080/api/v1/photos/page/v2
    @GetMapping("/page/v2")
    public Page<Photo> pagedIndexV2(@PageableDefault(page = 0, size = 5) Pageable pageable) {
        return photoService.getPage(pageable);
    }
}

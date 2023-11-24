package org.learning.springilmiofotoalbum.service;

import org.learning.springilmiofotoalbum.exception.PhotoTitleUniqueException;
import org.learning.springilmiofotoalbum.exception.PhotoNotFoundException;
import org.learning.springilmiofotoalbum.model.Photo;
import org.learning.springilmiofotoalbum.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    //Index
    public List<Photo> getPhotoList(Optional<String> search){
      if(search.isPresent()){
          return photoRepository.findByTitleContainingIgnoreCase(search.get());
      }
      else {
          return photoRepository.findAll();
      }
    }

    public List<Photo> getPhotoVisibility(Optional<String> search){
        if(search.isPresent()){
            return photoRepository.findByVisibleAndTitleContainingIgnoreCase(true, search.get());
        }
        else {
            return photoRepository.findByVisible(true);
        }
    }

    public List<Photo> getPhotoList() {
        return photoRepository.findAll();
    }

    //Show
    public Photo getPhotoById(Integer id) throws PhotoNotFoundException {
        Optional<Photo> result = photoRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }else {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "photo with id " + id + " not found");
        }
    }

    //Create
    public Photo createPhoto(Photo photo) throws PhotoTitleUniqueException {
        photo.setId(null);
        try{
            return photoRepository.save(photo);
        } catch (RuntimeException e) {
            throw new PhotoTitleUniqueException(photo.getTitle());
        }
    }

    //Edit
    public Photo editPhoto(Photo photo) throws PhotoNotFoundException {
        Photo photoToEdit = getPhotoById(photo.getId());

        photoToEdit.setTitle(photo.getTitle());
        photoToEdit.setVisible(photo.isVisible());
        photoToEdit.setImage(photo.getImage());
        photoToEdit.setDescription(photo.getDescription());
        photoToEdit.setCategories(photo.getCategories());

        return photoRepository.save(photoToEdit);
    }

    //Delete
    public void deletePhoto (Integer id) {
      photoRepository.deleteById(id);
    }

    //Pagination
    public Page<Photo> getPage(Pageable pageable) {
        return photoRepository.findAll(pageable);
    }
}

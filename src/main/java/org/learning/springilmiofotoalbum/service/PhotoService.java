package org.learning.springilmiofotoalbum.service;

import org.learning.springilmiofotoalbum.exception.PhotoNotFoundException;
import org.learning.springilmiofotoalbum.model.Photo;
import org.learning.springilmiofotoalbum.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    //Show
    public Photo getPhotoById(Integer id) throws PhotoNotFoundException {
        Optional<Photo> result = photoRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }else {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "photo with id " + id + " not found");
        }
    }
}

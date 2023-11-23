package org.learning.springilmiofotoalbum.service;

import org.learning.springilmiofotoalbum.model.Photo;
import org.learning.springilmiofotoalbum.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

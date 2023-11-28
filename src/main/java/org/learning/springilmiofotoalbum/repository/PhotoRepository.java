package org.learning.springilmiofotoalbum.repository;

import org.learning.springilmiofotoalbum.model.Photo;
import org.learning.springilmiofotoalbum.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {

    //Backend
    List<Photo> findByTitleContainingIgnoreCase(String titleKeyword);
    List<Photo> findByUserIdAndTitleContainingIgnoreCase(Integer userId, String titleKeyword);
    List<Photo> findByUserId(Integer userId);

    //Frontend
    List<Photo> findByVisible(boolean visible);
    List<Photo> findByVisibleAndTitleContainingIgnoreCase(boolean visible, String titleKeyword);
    List<Photo> findByUserIdAndVisible(Integer userId, boolean visible);
    List<Photo> findByUserIdAndVisibleAndTitleContainingIgnoreCase(
            Integer userId, boolean visible, String titleKeyword
    );
}

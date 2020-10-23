package com.example.images.repository;

import com.example.images.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ImagesRepository extends JpaRepository<Picture, String> {

    @Query("SELECT p FROM picture p WHERE p.id LIKE %:criteria% OR p.author LIKE %:criteria% OR p.camera LIKE %:criteria% OR p.cropped_picture LIKE %:criteria% OR p.full_picture LIKE %:criteria%")
    List<Picture> findByAnyCriteria(@Param("criteria") String criteria);

}

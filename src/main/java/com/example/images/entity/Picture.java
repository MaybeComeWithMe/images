package com.example.images.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "picture")
public class Picture {
    @Id
    private String id;
    private String author;
    private String camera;
    private String cropped_picture;
    private String full_picture;

    public Picture() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getCropped_picture() {
        return cropped_picture;
    }

    public void setCropped_picture(String cropped_picture) {
        this.cropped_picture = cropped_picture;
    }

    public String getFull_picture() {
        return full_picture;
    }

    public void setFull_picture(String full_picture) {
        this.full_picture = full_picture;
    }
}

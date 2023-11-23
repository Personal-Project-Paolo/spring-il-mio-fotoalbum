package org.learning.springilmiofotoalbum.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "photos")
public class photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Title must not be blank")
    @Size(max = 255, message = "Length must be less than 255")
    private String title;

    @NotBlank(message = "Description must not be blank")
    @Size(max = 1255, message = "Length must be less than 1255")
    @Column(length = 1255)
    private String description;

    @NotBlank(message = "Image must not be blank")
    @Size(max = 2500, message = "Length must be less than 2500")
    @Column(length = 2500)
    private String image;

    private boolean visible = false;

    //Getter e Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
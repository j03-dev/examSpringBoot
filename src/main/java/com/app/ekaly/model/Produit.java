package com.app.ekaly.model;

import javax.persistence.*;

@Entity
@Table(name = "produit")
public class Produit {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 50, nullable = false, unique = true)
    private String name;

    @Column(name = "photo", length = 255, nullable = false)
    private String photo;

    @Column(name = "prix")
    private Integer prix;

    @Column(name = "description", length = 255, nullable = true)
    private String description;

    public Produit(String name, String photo, String description, String prix) {

    }

    public Produit(String name, String photo, Integer prix, String description) {
        this.name = name;
        this.photo = photo;
        this.prix = prix;
        this.description = description;
    }

    public Produit(Long id, String name, String photo, Integer prix, String description) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.prix = prix;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", name='" + name + '\'' + ", prix=" + prix + ", description='" + description + '\'' + '}';
    }
}

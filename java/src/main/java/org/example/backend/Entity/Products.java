package org.example.backend.Entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String product_name;
    private String product_description;
    private int longitude;
    private int latitude;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @OneToMany(mappedBy = "product")
    private Set<Image> images = new HashSet<>();

    public Products() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    public Products(int id, String product_name, String product_description, int longitude, int latitude, User user, Set<Image> images) {
        this.id = id;
        this.product_name = product_name;
        this.product_description = product_description;
        this.longitude = longitude;
        this.latitude = latitude;
        this.user = user;
        this.images = images;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", product_name='" + product_name + '\'' +
                ", product_description='" + product_description + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", user=" + user +
                ", images=" + images +
                '}';
    }
}


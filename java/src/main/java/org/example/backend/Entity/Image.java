package org.example.backend.Entity;

import jakarta.persistence.*;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String url;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="product_id", referencedColumnName = "id")
    private Products product;

    public Image() {
    }

    public Image(int id, String url, Products product) {
        this.id = id;
        this.url = url;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", product=" + product +
                '}';
    }
}

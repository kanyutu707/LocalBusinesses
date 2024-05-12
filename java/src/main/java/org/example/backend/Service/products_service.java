package org.example.backend.Service;

import org.example.backend.Entity.Products;
import org.example.backend.Repository.Product_Repo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class products_service {
    private Product_Repo repository;

    public void Repository(Product_Repo repository) {
        this.repository = repository;
    }

    public ResponseEntity<List<Products>> getAllProducts(){
        List<Products> products = repository.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    public ResponseEntity<Products> getProductById(int id){
        Optional<Products> productsOptional=repository.findById(id);
        return productsOptional.map(products -> new ResponseEntity<>(products, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    public ResponseEntity<Products> createProduct(Products products){
        Products createdProduct=repository.save(products);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }
    public ResponseEntity<Products> updateProduct(int id, Products updateProducts){
        Optional<Products> productsOptional=repository.findById(id);
        if(productsOptional.isPresent()){
            Products existingProduct=productsOptional.get();
            existingProduct.setProduct_name(updateProducts.getProduct_name());
            existingProduct.setProduct_description(updateProducts.getProduct_description());
            Products updatedProduct=repository.save(existingProduct);
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    public ResponseEntity<Void> deleteProduct(int id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

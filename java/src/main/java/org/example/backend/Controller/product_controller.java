package org.example.backend.Controller;

import org.example.backend.Entity.Products;
import org.example.backend.Service.products_service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class product_controller {
    private products_service service;

    public void Service(products_service service) {
        this.service = service;
    }

    @GetMapping("/create_product")
    public ResponseEntity<List<Products>> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @PostMapping("/get_products")
    public ResponseEntity<Products> createProduct(@RequestBody Products product) {
        return service.createProduct(product);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<Products> updateProduct(@PathVariable int id, @RequestBody Products updateProduct) {
        return service.updateProduct(id, updateProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        service.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}

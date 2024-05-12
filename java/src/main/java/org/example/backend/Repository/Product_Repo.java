package org.example.backend.Repository;

import org.example.backend.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Product_Repo extends JpaRepository<Products, Integer> {
}

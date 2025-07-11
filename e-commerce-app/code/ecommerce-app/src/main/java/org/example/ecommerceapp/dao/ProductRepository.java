package org.example.ecommerceapp.dao;

import org.example.ecommerceapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

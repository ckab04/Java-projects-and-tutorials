package org.example.ecommerceapp.dao;

import org.example.ecommerceapp.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "productCategory", path="product-category")
public interface ProductCategoryRepository  extends JpaRepository<ProductCategory, Long> {
}

package com.example.srutkowski.shop.product.domain;

import com.example.srutkowski.shop.product.domain.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}

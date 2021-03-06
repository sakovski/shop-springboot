package com.example.srutkowski.shop.product;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProductService {

    private final ProductRepository productRepository;

    public GetProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProductsSortedByName() {
        return productRepository.findAll(new Sort(Sort.Direction.ASC, "name"));
    }
}

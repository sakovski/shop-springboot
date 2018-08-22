package com.example.srutkowski.shop.product.domain;

import com.example.srutkowski.shop.product.domain.Product;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="product_category")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "productCategory", fetch = FetchType.EAGER)
    private Set<Product> products;

    @Column(name = "enabled")
    private boolean enabled;

    public ProductCategory(String name, boolean enabled) {
        this.name = name;
        this.products = new HashSet<>();
        this.enabled = enabled;
    }

    public ProductCategory() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

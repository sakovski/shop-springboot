package com.example.srutkowski.shop;

import com.example.srutkowski.shop.config.AppProfiles;
import com.example.srutkowski.shop.order.OrderRepository;
import com.example.srutkowski.shop.product.Product;
import com.example.srutkowski.shop.product.ProductCategory;
import com.example.srutkowski.shop.product.ProductCategoryRepository;
import com.example.srutkowski.shop.product.ProductRepository;
import com.example.srutkowski.shop.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Profile(AppProfiles.DEV)
@Component
public class DbInitializer implements ApplicationRunner {

    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;
    private OrderRepository orderRepository;
    private ProductRepository productRepository;
    private ProductCategoryRepository productCategoryRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public DbInitializer(UserRepository userRepository,
                         UserRoleRepository userRoleRepository,
                         OrderRepository orderRepository,
                         ProductRepository productRepository,
                         ProductCategoryRepository productCategoryRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.productCategoryRepository = productCategoryRepository;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder(11);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        UserRole user = new UserRole(RoleType.CUSTOMER, true);
        UserRole admin = new UserRole(RoleType.ADMIN, true);
        userRoleRepository.save(user);
        userRoleRepository.save(admin);
        userRepository.save(new User("testuser@wp.pl", bCryptPasswordEncoder.encode("user"), user, "UerTest", "UserTest", true));
        userRepository.save(new User("testadmin@wp.pl", bCryptPasswordEncoder.encode("admin"), admin, "AdminTest", "AdminTest", true));
        ProductCategory food = new ProductCategory("Water", true);
        ProductCategory clothes = new ProductCategory("Clothes", true);
        productCategoryRepository.save(food);
        productCategoryRepository.save(clothes);
        productRepository.save(new Product("Water 1l", food, "1l bottle of water", new BigDecimal("1.99"), 45, null, true ));
        productRepository.save(new Product("Can of tuna 500g", food, "500g can of tuna", new BigDecimal("5.20"), 100, null, true ));
        productRepository.save(new Product("T-shirt", clothes, "Comfortable t-shirt for summer", new BigDecimal("20.99"), 25, null, true ));
        productRepository.save(new Product("Jeans for men", clothes, "Very good looking jeans", new BigDecimal("100.55"), 34, null, true ));

    }
}

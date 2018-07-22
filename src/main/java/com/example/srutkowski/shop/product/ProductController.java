package com.example.srutkowski.shop.product;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    private final GetProductService getProductService;

    public ProductController(GetProductService getProductService) {
        this.getProductService = getProductService;
    }

    @GetMapping("/product")
    public String index(Model model) {
        model.addAttribute("products", getProductService.getAllProductsSortedByName());
        return "product/index";
    }

}

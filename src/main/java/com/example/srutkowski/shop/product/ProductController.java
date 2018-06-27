package com.example.srutkowski.shop.product;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("product")
public class ProductController {

    @GetMapping("/index")
    public String index(Model model) {
        return "product/index";
    }

}

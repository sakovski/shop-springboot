package com.example.srutkowski.shop.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserRegisterService userRegisterService;

    public UserController(UserRegisterService userRegisterService) {
        this.userRegisterService = userRegisterService;
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        RegisterForm registerForm = new RegisterForm();
        model.addAttribute(registerForm);
        return "user/register";
    }

    @PostMapping("/register")
    public String saveRegister(Model model, @ModelAttribute("registerForm") @Validated RegisterForm registerForm) {
        try {
            userRegisterService.registerNewUser(registerForm);
        }catch(Exception e) {
            model.addAttribute("errorMessage", "Error: " + e.getMessage());
            return "user/register";
        }
        return "user/register_success";
    }
}

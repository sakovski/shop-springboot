package com.example.srutkowski.shop.user;

import com.example.srutkowski.shop.user.register.RegisterForm;
import com.example.srutkowski.shop.user.register.UserRegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

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
    public String saveRegister(Model model,
                               @Valid RegisterForm registerForm,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            //model.addAttribute("errorMessage", "Error: " + e.getMessage());
            return "user/register";
        }
        userRegisterService.registerNewUser(registerForm);
        return "user/register_success";
    }
}

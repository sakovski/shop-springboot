package com.example.srutkowski.shop.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RegisterForm {

    @Email
    @NotNull
    @NotBlank
    private String email;

    //TODO: PASSWORD REGEX ANNOTATION
    @NotNull
    @NotBlank
    private String password;

    //TODO: CONFIRM PASSWORD COMAPARE WITH PASSWORD ANNOTATION
    @NotNull
    @NotBlank
    private String confirmPassword;

    private String firstName;

    private String lastName;

    public RegisterForm(@Email @NotNull @NotBlank String email, String password, String confirmPassword, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public RegisterForm() {
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

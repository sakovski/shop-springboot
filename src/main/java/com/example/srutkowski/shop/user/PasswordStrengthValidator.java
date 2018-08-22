package com.example.srutkowski.shop.user;

import com.nulabinc.zxcvbn.Strength;
import com.nulabinc.zxcvbn.Zxcvbn;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordStrengthValidator implements ConstraintValidator<PasswordStrengthCheck, String> {

    private final Zxcvbn passwordStrengthCheck;

    @Value("${password.strength}")
    private Integer passwordStrength;

    public PasswordStrengthValidator(Zxcvbn passwordStrengthCheck) {
        this.passwordStrengthCheck = passwordStrengthCheck;
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        Strength strength = passwordStrengthCheck.measure(password);
        if (strength.getScore() < passwordStrength) {
            return false;
        }
        return true;
    }
}

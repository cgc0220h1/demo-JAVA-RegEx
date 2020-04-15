package com.regex;

import java.util.regex.Pattern;

public class EmailValidation {
    private static Pattern pattern;
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    public EmailValidation() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }

    public boolean validate(String input) {
        return pattern.matcher(input).matches();
    }

    public static void main(String[] args) {
        boolean isValid;
        EmailValidation emailValidation = new EmailValidation();
        String[] emails = {"a@gmail.com"
                ,"ab@yahoo.com"
                ,"abc@hotmail.com"
                ,"@gmail.com"
                ,"ab@gmail."
                ,"@#abc@gmail.com"};
        for (String email : emails) {
            isValid = emailValidation.validate(email);
            System.out.println("Email is " + email + " is valid: " + isValid);
        }
    }
}

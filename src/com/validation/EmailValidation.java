package com.validation;

import java.util.regex.Pattern;

public class EmailValidation {
    private static Pattern pattern;
    private static final String EMAIL_REGEX = "^\\D\\w*@\\w+\\.(\\w{2,3}|\\.\\w{2,3})";

    public EmailValidation() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }

    public boolean validate(String input) {
        return pattern.matcher(input).find();
    }

    public static void main(String[] args) {
        boolean isValid;
        EmailValidation emailValidation = new EmailValidation();
        String[] emails = {"a@gmail.com"
                ,"ab@yahoo.com"
                ,"abc@hotmail.com"
                ,"namCT@yahoo.com.vn"
                ,"@gmail.com"
                ,"ab@gmail."
                ,"@#abc@gmail.com"};
        for (String email : emails) {
            isValid = emailValidation.validate(email);
            System.out.println("Email is " + email + " is valid: " + isValid);
        }
    }
}

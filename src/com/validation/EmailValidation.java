package com.validation;

public class EmailValidation {
    public static void main(String[] args) {
        final String EMAIL_REGEX = "^\\D\\w*@\\w+\\.(\\w{2,3}|\\.\\w{2,3})";
        boolean isValid;
        Validation validation = new Validation(EMAIL_REGEX);
        String[] emails = {"a@gmail.com"
                , "ab@yahoo.com"
                , "abc@hotmail.com"
                , "namCT@yahoo.com.vn"
                , "@gmail.com"
                , "ab@gmail."
                , "@#abc@gmail.com"};
        for (String email : emails) {
            isValid = validation.validate(email);
            System.out.println("Email is " + email + " is valid: " + isValid);
        }
    }
}

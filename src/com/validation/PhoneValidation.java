package com.validation;

public class PhoneValidation {
    public static void main(String[] args) {
        final String PHONE_REGEX = "^\\(\\d{2}\\)\\-\\(\\d{10}\\)$";
        Validation validation = new Validation(PHONE_REGEX);
        String[] toValidate = {"(84)-(0978489648)","(a8)-(22222222)"};
        for (String phoneNumber : toValidate) {
            boolean isValid = validation.validate(phoneNumber);
            System.out.println(phoneNumber + " is Valid: " + isValid);
        }
    }
}

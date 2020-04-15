package com.validation;

public class ClassValidation {
    public static void main(String[] args) {
        final String CLASS_REGEX = "^[CAP]\\d{4}[GHIKLM]$";
        Validation validation = new Validation(CLASS_REGEX);
        String[] toValidate = {"C0318G","M0318G","P0323A","C@082A","A8291M"};
        for (String className : toValidate) {
            boolean isValid = validation.validate(className);
            System.out.println(className + " is valid: " + isValid);
        }
    }
}

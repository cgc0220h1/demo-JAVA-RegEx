package com.validation;

import java.util.regex.Pattern;

public class Validation {
    private static Pattern pattern;
    public Validation(String regex) {
        pattern = Pattern.compile(regex);
    }

    public boolean validate(String input) {
        return pattern.matcher(input).find();
    }
}

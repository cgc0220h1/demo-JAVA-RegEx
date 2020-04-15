package com.validation;

public class AccountValidation {
    public static void main(String[] args) {
        final String ACCOUNT_REGEX = "^[a-z0-9][_a-z0-9]{6,}";
        Validation validation = new Validation(ACCOUNT_REGEX);
        String[] toTest = {"123abc_"
                , "_abc123"
                , "______"
                , "123456"
                , "abcdefgh"
                , ".@"
                , "12345"
                , "1234_"
                , "abcde"};
        for (String accName : toTest) {
            if (validation.validate(accName)) {
                System.out.println(accName + ": is valid");
            } else {
                System.out.println(accName + ": is not valid");
            }
        }
    }
}

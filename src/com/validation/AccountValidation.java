package com.validation;

import java.util.regex.Pattern;

public class AccountValidation {
    private static Pattern pattern;
    private static final String ACCOUNT_REGEX = "^[a-z0-9][_a-z0-9]{6,}";

    public AccountValidation() {
        pattern = Pattern.compile(ACCOUNT_REGEX);
    }

    public boolean validate(String accountName) {
        return pattern.matcher(accountName).find();
    }

    public static void main(String[] args) {
        AccountValidation accountValidation = new AccountValidation();
        String[] toTest = {"123abc_"
                , "_abc123"
                , "______"
                , "123456"
                ,"abcdefgh"
                ,".@"
                , "12345"
                , "1234_"
                , "abcde"};
        for (String accName : toTest) {
            if (accountValidation.validate(accName)) {
                System.out.println(accName + ": is valid");
            } else {
                System.out.println(accName + ": is not valid");
            }
        }
    }
}

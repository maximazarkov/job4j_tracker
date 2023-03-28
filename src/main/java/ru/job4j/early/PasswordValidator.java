package ru.job4j.early;

public class PasswordValidator {

    public static String validate(String password) {
        String[] listOfSubStrings = {
                "qwerty",
                "password",
                "user",
                "admin",
                "12345"};

        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() > 32 || password.length() < 8) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        checkPasswordLetter(password);
        if (checkContainSubstring(password, listOfSubStrings)) {
            throw new IllegalArgumentException(
                    "Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }
        return password;
    }

    private static void checkPasswordLetter(String password) {
        boolean isLowerCase = true;
        boolean isUpperCase = true;
        boolean isDigit = true;
        boolean isSpecialSimbol = true;
        for (char c : password.toCharArray()) {
            if (!isDigit && !isSpecialSimbol && !isLowerCase && !isUpperCase) {
                break;
            } else if (Character.isLowerCase(c)) {
                isLowerCase = false;
            } else if (Character.isUpperCase(c)) {
                isUpperCase = false;
            } else if (Character.isDigit(c)) {
                isDigit = false;
            } else if (!Character.isDigit(c)
                    && !Character.isUpperCase(c)
                    && !Character.isLowerCase(c)
            ) {
                isSpecialSimbol = false;
            }
        }
        if (isLowerCase) {
            throw new IllegalArgumentException("Password should contain "
                    + "at least one lowercase letter");
        }
        if (isUpperCase) {
            throw new IllegalArgumentException("Password should contain "
                    + "at least one uppercase letter");
        }
        if (isDigit) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (isSpecialSimbol) {
            throw new IllegalArgumentException(
                    "Password should contain at least one special symbol");
        }
    }

    private static boolean checkContainSubstring(String password, String[] listOfSubStrings) {
        for (String subString : listOfSubStrings) {
            if (password.toLowerCase().contains(subString)) {
                return true;
            }
        }
        return false;
    }
}

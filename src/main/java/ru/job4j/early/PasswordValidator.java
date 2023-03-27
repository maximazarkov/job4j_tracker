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

        try {
            checkPasswordLetter(password);
        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException(iae.getMessage());
        }

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
        char currentCharacter;
        for (int i = 0; i < password.length(); i++) {
            currentCharacter = password.charAt(i);
            if (Character.isLowerCase(currentCharacter)) {
                isLowerCase = false;
            } else if (Character.isUpperCase(currentCharacter)) {
                isUpperCase = false;
            } else if (Character.isDigit(currentCharacter)) {
                isDigit = false;
            } else if (!Character.isDigit(currentCharacter)
                    && !Character.isUpperCase(currentCharacter)
                    && !Character.isLowerCase(currentCharacter)
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

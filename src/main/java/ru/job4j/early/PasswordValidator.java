package ru.job4j.early;

public class PasswordValidator {

    public static String validate(String password) {

        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() > 32 || password.length() < 8) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }

        if (!checkUpperCaseLatter(password)) {
            throw new IllegalArgumentException("Password should contain "
                    + "at least one uppercase letter");
        }

        if (!checkLowerCaseLatter(password)) {
            throw new IllegalArgumentException("Password should contain "
                    + "at least one lowercase letter");
        }

        if (!checkIsDigit(password)) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }

        if (!checkSpecialSimbol(password)) {
            throw new IllegalArgumentException(
                    "Password should contain at least one special symbol");
        }

        if (checkContainSubstring(password)) {
            throw new IllegalArgumentException(
                    "Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }

        return password;
        /**
         * 6) Пароль не содержит подстрок без учета регистра: qwerty, 12345, password, admin,
         * user. Без учета регистра, значит что, например, ни qwerty ни QWERTY ни qwErty и т.п.
         * не должно быть в составе пароля ("Password shouldn't contain substrings: qwerty,
         * 12345, password, admin, user").
         *
         * Для проверок использовать статические методы класса Character.
         */
    }

    private static boolean checkContainSubstring(String password) {
        String[] listOfSubStrings = {
                "qwerty",
                "password",
                "user",
                "admin",
                "12345"};
        for (String subString : listOfSubStrings) {
            if (password.toLowerCase().contains(subString)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkSpecialSimbol(String password) {
        String specialChars = "~`!@#$%^&*()-_=+\\|[{]};:'\",<.>/?";
        char currentCharacter;

        for (int i = 0; i < password.length(); i++) {
            currentCharacter = password.charAt(i);
            if (specialChars.contains(String.valueOf(currentCharacter))) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkIsDigit(String password) {
        char currentCharacter;
        for (int i = 0; i < password.length(); i++) {
            currentCharacter = password.charAt(i);
            if (Character.isDigit(currentCharacter)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkLowerCaseLatter(String password) {
        char currentCharacter;
        for (int i = 0; i < password.length(); i++) {
            currentCharacter = password.charAt(i);
            if (Character.isLowerCase(currentCharacter)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkUpperCaseLatter(String password) {
        char currentCharacter;
        for (int i = 0; i < password.length(); i++) {
            currentCharacter = password.charAt(i);
            if (Character.isUpperCase(currentCharacter)) {
                return true;
            }
        }
        return false;
    }
}

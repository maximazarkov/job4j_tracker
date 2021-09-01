package ru.job4j.ex;

public class JdbcConfig {
    public static void load(String url) throws UserInputException {
        if (url == null) {
            throw new UserInputException("Url could not be null");
        }
        /*load jdbc*/
    }

        // Первый вариант - пробросить исключение дальше по иерархии классов.
//    public static void main(String[] args) throws UserInputException {
    public static void main(String[] args) {
        // но лучше использовать второй вариант (по ситуации) - try...catch.
         try {
            load("jdbc://localhost:8080");
        } catch (UserInputException e) {
            e.printStackTrace();
        }
    }
}

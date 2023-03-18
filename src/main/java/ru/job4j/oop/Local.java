package ru.job4j.oop;

public class Local {
    private String name = "Максим";

    public void getFullName() {
        final String surname = "Азарков";

        class FullName {
            public void printFullName() {
                System.out.println(name + " " + surname);
            }
        }

        FullName fullName = new FullName();
        fullName.printFullName();
    }

    public static void main(String[] args) {
        Local local = new Local();
        local.getFullName();
    }
}

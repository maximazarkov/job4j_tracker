package ru.job4j.lambda;

public class Model {
    private String name;

    public Model() {
        this.name = "Default";
    }

    public Model(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getNameEx() {

        return "===" + name + "===";
    }
}

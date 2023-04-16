package ru.job4j.lambda;

/**
 * Пример работы с функциональным интерфейсом без его реализации.
 * Сначала, вместо реализации интерфейса создается ссылка на конструктор Model(String) {}, така
 * как метод function(String s) так же принимает
 */
public class ConstructorRefMain {
    public static void main(String[] args) {
        FuncInterface modelConstructor = Model::new;
        Model model = modelConstructor.function("Example");
        System.out.println("Значение равно: " + model.getName());
        System.out.println("Значение равно: "
                + modelConstructor.function("Example 2").getName());

        FuncInterfaceDefault modelConstructorDefault = Model::new;
        Model modelDefault = modelConstructorDefault.function();
        System.out.println("Значение через конструктор по умолчанию: " + modelDefault.getName());
        System.out.println("Значение через конструктор по умолчанию: " + modelDefault.getNameEx());
    }
}

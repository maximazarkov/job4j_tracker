package ru.job4j.polymorph;

/**
 * Пример дефолтных и приватных методов.
 * Конфликты дефолтный методов описаны в MainFunc.java
 *
 * - Приватные методы.
 * Последний тип методов, которые могут быть объявлены в интерфейсах - это приватные. Они
 * обозначаются ключевым словом private. Они могут быть как статическими, так и нестатическими.
 * Эти методы используются в интерфейсах для того, чтобы вынести какую то логику из публичных
 * статических или дефолтных методов, либо для предотвращения дублирования кода. В приватный
 * метод можно убрать все детали реализации, чтобы уменьшить пользовательский код и упростить
 * его читаемость, также в private методы нужно убирать задвоившийся код.
 *
 * Например, если один дефолтный метод должен возвращать среднее арифметическое элементов массива,
 * а другой - удвоенную сумму элементов, мы можем вынести нахождение суммы элементов в отдельный
 * private - метод. Добавим в интерфейс Func1 методы getDoubleSum(), getAverage() и getSum():
 */

public interface Func1 {
    default double func(double x, double y) {
        return x * x - 2 * y + 30;
    }

    default void funcMessage() {
        System.out.println("Сообщение из Func1");
    }

    default int getDoubleSum(int[] numbers) {
        return getSum(numbers) * 2;
    }

    default double getAverage(int[] numbers) {
        return getSum(numbers) * 1.0 / numbers.length;
    }

    private int getSum(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}

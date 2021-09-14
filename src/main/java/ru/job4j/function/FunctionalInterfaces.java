package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
//        Несмотря на то, что BiConsumer ничего не возвращает, в лямбда все равно
//        можно включить ссылку на внешнюю переменную. Применим сокращенную форму
        BiConsumer<Integer, String> biCon = map::put;
        /*
            Замените вставку элементов в карту на использование BiConsumer, он уже объявлен, требуется его реализовать.
         */
//        map.put(1, "one");
//        map.put(2, "two");
//        map.put(3, "three");
//        map.put(4, "four");
//        map.put(5, "five");
//        map.put(6, "six");
//        map.put(7, "seven");
        biCon.accept(1, "one");
        biCon.accept(2, "two");
        biCon.accept(3, "three");
        biCon.accept(4, "four");
        biCon.accept(5, "five");
        biCon.accept(6, "six");
        biCon.accept(7, "seven");

// Данный пример избыточен, т.к. достаточно было выполнить Predicate
        BiPredicate<Integer, String> biPred = (i1, s1) ->  i1 % 2 == 0 || s1.length() == 4;
        for (Integer i : map.keySet()) {
            /*
                Замените проверку в if() на использование BiPredicate, он объявлен выше, требуется его реализовать.
             */
//            if (i % 2 == 0 || map.get(i).length() == 4) {
            if (biPred.test(i,map.get(i))) {
                System.out.println("key: " + i + " value: " + map.get(i));
            }
        }
        System.out.println("---");
// Для практики (сверх поставленной задачи) выполним ту же проверку на чистом Predicate
        Predicate<Integer> pred = (i1) ->  i1 % 2 == 0 || map.get(i1).length() == 4;
        for (Integer i : map.keySet()) {
            /*
                Замените проверку в if() на использование BiPredicate, он объявлен выше, требуется его реализовать.
             */
//            if (i % 2 == 0 || map.get(i).length() == 4) {
            if (pred.test(i)) {
                System.out.println("key: " + i + " value: " + map.get(i));
            }
        }

        /*
            Заменить создание ArrayList из значений Map на Supplier, объявлен ниже, требуется его реализовать.
         */
//        Из Suplier несложно достать содержимое, например, List... (см.for ниже)
        Supplier<List<String>> sup = () -> new ArrayList<>(map.values());
//        List<String> strings = new ArrayList<>(map.values());

// Чтобы заменить конструкцию System.out.println(s.toUpperCase());
// реализуем два функциональных интерфейса.
// Первый заменяет sout.
        Consumer<String> con = System.out::println;
// Второй - преобразует контент.
        Function<String, String> func = String::toUpperCase;
//        for (String s : strings) {
        for (String s : sup.get()) {
            /*
                Заменить вывод строк на применение Consumer
                Заменить преобразование строк к строкам в верхнем регистре с помощью Function
                Необходимое объявлено выше, требуется их реализовать.
            */
//            System.out.println(s.toUpperCase());
            con.accept(func.apply(s));
        }
    }
}

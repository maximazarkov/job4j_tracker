package ru.job4j.pojo;

public class Store {
    public static void main(String[] args) {
        Product bolometr1 = new Product(
                1,
                123,
                "Болометр",
                "БП-2М",
                "2020-10");

        Product bolometr2 = new Product(
                2,
                234,
                "Болометр",
                "БП-2М",
                "2020-10");

        Product module = new Product(
                3,
                321,
                "Модуль",
                "УПСЧ",
                "2018-01");

        Product[] sklad = new Product[3];
        sklad[0] = bolometr1;
        sklad[1] = bolometr2;
        sklad[2] = module;

        for (int index = 0; index < 3; index++) {
            Product pr = sklad[index];
            System.out.println(pr.getName() + " " + pr.getType() + " " + pr.getRelease());
        }

        Product bunk = new Product(
                4,
                555,
                "Блок управления напольными камерами",
                "БУНК",
                "2021-05");

        sklad[0] = bunk;

        System.out.println("---");

        for (int index = 0; index < 3; index++) {
            Product pr = sklad[index];
            System.out.println(pr.getName() + " " + pr.getType() + " " + pr.getRelease());
        }
    }

}

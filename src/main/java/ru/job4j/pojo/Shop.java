package ru.job4j.pojo;

public class Shop {
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

        Product[] products = new Product[5];
        products[0] = bolometr1;
        products[1] = bolometr2;

        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            /* проверяем, что объект не равен null. Т.к. у нас массив не заполнен целиком. */
            if (product != null) {
                System.out.println(product.getName());
            }
        }

        System.out.println(indexOfNull(products));
    }

    public static int indexOfNull(Product[] products) {
        int rlt = -1;
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product == null) {
                rlt = i;
                break;
            }
        }
        return rlt;
    }
}

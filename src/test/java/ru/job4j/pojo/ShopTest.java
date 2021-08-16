package ru.job4j.pojo;

import org.junit.Assert;
import org.junit.Test;

public class ShopTest {

    @Test
    public void whenLastNull() {
        Product[] products = new Product[5];
        products[0] = new Product(
                1,
                123,
                "Болометр",
                "БП-2М",
                "2020-10");
        products[1] = new Product(
                2,
                234,
                "Болометр",
                "БП-2М",
                "2020-10");
        int exp = 2;
        int rsl = Shop.indexOfNull(products);
        Assert.assertEquals(exp, rsl);
    }

    @Test
    public void whenFirstNull() {
        Product[] products = new Product[5];
        products[1] = new Product(2,
                234,
                "Болометр",
                "БП-2М",
                "2020-10");
        int exp = 0;
        int rsl = Shop.indexOfNull(products);
        Assert.assertEquals(exp, rsl);
    }

    @Test
    public void whenHasNotNull() {
        Product[] products = new Product[1];
        products[0] = new Product(2,
                234,
                "Болометр",
                "БП-2М",
                "2020-10");
        int exp = -1;
        int rsl = Shop.indexOfNull(products);
        Assert.assertEquals(exp, rsl);
    }
}
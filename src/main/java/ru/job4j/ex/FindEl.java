package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        /* цикл fori, поскольку нам надо найти индекс искомого элемента в массиве */
        for (int index = 0; index < value.length; index++) {
            if (key.equals(value[index])) {
                rsl = index;
                break;
            }
        }
        if (rsl < 0) {
            throw new ElementNotFoundException("Element not found");
        }
        return rsl;
    }

    public static void main(String[] args) throws ElementNotFoundException {
        String[] array = new String[] {"aaa", "bbb", "ccc"};
        try {
            indexOf(array, "ddd");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}

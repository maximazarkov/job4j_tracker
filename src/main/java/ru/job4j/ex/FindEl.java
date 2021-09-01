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

    public static boolean sent(String value, String[] abuses) throws ElementAbuseExtension {
        /* if contains throw ElementAbuseException */
        for (String el : abuses) {
            if (value.equals(el)) {
                throw new ElementAbuseExtension("Abuses contains values: " + el);
            }
        }
        return true;
    }

    public static void process(String[] values, String key, String[] abuses) {
        try {
            if (indexOf(values, key) != -1) {
                sent(key, abuses);
            }
        } catch (ElementAbuseExtension ea) {
            ea.printStackTrace();
        } catch (ElementNotFoundException en) {
            en.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void main(String[] args) throws ElementNotFoundException {
        String[] array = new String[] {"aaa", "bbb", "ccc"};
        String key = "ccc";
        String[] abuses = {"ddd", "ccc"};
        process(array, key, abuses);
    }
}

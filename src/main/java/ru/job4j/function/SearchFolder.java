package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchFolder {
    /**
     *  Метод для фильтрации по размеру
     * @param list Список
     * @return Перечень найденных файлов
     * @deprecated Рекомендуется использовать метод
     * filter(List<Folder> list, Predicate<Folder> pred)...
     */
    @Deprecated
    public static List<Folder> filterSize(List<Folder> list) {
        return filter(list, f -> f.getSize() > 100);
    }

    /**
     *  Метод для фильтрации по имени
     * @param list Список
     * @return Перечень найденных файлов
     * @deprecated Рекомендуется использовать метод
     * filter(List<Folder> list, Predicate<Folder> pred)...
     */
    @Deprecated
    public static List<Folder> filterName(List<Folder> list) {
        return filter(list, f -> f.getName().contains("bug"));
    }

    public static List<Folder> filter(List<Folder> list, Predicate<Folder> pred) {
        List<Folder> rsl = new ArrayList<>();
        for (Folder f : list) {
            if (pred.test(f)) {
                rsl.add(f);
            }
        }
        return rsl;
    }
}

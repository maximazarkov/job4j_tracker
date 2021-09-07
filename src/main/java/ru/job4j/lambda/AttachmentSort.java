package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );
        //Анонимный класс реализующий интерфейс Comparator.
        //В анонимном классе нет имени класса.
        //Анонимный класс можно создать на основании класса или интерфейса.
        Comparator<Attachment> comparator =  new Comparator<>() {
            @Override
            public int compare(Attachment left, Attachment right) {
                return left.getSize() - right.getSize();
            }
        };
        attachments.sort(comparator);
        System.out.println(attachments);

        // для сравнения выполним анонимный класс в виде lambda.
//        Comparator<Attachment> comparatorName = (o1, o2) -> o1.getName().compareTo(o2.getName());
        // ну и трансформируем дальше
        Comparator<Attachment> comparatorName = Comparator.comparing(Attachment::getName);
        attachments.sort(comparatorName);
        System.out.println(attachments);
    }
}

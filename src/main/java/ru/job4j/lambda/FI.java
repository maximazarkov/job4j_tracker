package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collector;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23)
        };
        Comparator<Attachment> comparator = (left, right) -> left.getSize() - right.getSize();
        Arrays.sort(atts, comparator);
        Comparator<String> cmpText = (left, right) -> left.compareTo(right) ;
        Comparator<String> cmpDescSize = (left, right) -> right.compareTo(left) ;

        String[] names = {
                "Ivan",
                "Petr"
        };
        Comparator<String> lengthCmp = (left, right) -> {
            System.out.println("execute comparator");
            return left.length() - right.length();
        };
        Arrays.sort(names, lengthCmp);
    }
}

package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaUsage {

    public static void main(String[] args) {
        Comparator<String> cmpText1 = (left, right) -> left.compareTo(right);
        Comparator<String> cmpText2 = String::compareTo;

        Comparator<String> cmpDescSize = (left, right) -> (left.length() - right.length());
        cmpDescSize = Comparator.reverseOrder();

        String[] numbers = {
                "1. Task",
                "11. Task",
                "2. Task"
        };

        Comparator<String> numStr = (left, right) -> {
            int first = Integer.valueOf(left.substring(0, left.indexOf(".")));
            int second = Integer.valueOf(right.substring(0, right.indexOf(".")));
            return first - second;
        };

        //было
        Comparator<Attachment> comparator = (left, right) -> left.getSize() - right.getSize();
        // стало
        Comparator<Attachment> comp = (left, right) -> {
            System.out.println("compare - " + left.getSize() + " : " + right.getSize());
            return Integer.compare(left.getSize(), right.getSize());
        };

        Comparator<String> cmpDescSizeLog = (left, right) -> {
            System.out.println((right.length() > left.length()) ? "right > left" : "right < left");
            return Integer.compare(right.length(), left.length());
        };

        Arrays.sort(numbers, cmpDescSizeLog);
        for (String s : numbers) {
            System.out.println(s);
        }

    }
}


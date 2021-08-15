package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Book1", 100);
        Book book2 = new Book("Book2", 200);
        Book book3 = new Book("Book3", 300);
        Book book4 = new Book("Clean code", 150);
        Book[] library = new Book[4];
        library[0] = book1;
        library[1] = book2;
        library[2] = book3;
        library[3] = book4;
        for (int index = 0; index < library.length; index++) {
            System.out.println(library[index].getName() + "-" + library[index].getNumOfPages());
        }
        Book tmp = library[0];
        library[0] = library[3];
        library[3] = tmp;
        System.out.println("---");
        for (int index = 0; index < library.length; index++) {
            System.out.println(library[index].getName() + "-" + library[index].getNumOfPages());
        }
        System.out.println("---");
        for (int index = 0; index < library.length; index++) {
            if (library[index].getName().equals("Clean code")) {
                System.out.println(library[index].getName() + "-" + library[index].getNumOfPages());
            }
        }
    }
}

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
        for (Book book : library) {
            System.out.println(book.getName() + "-" + book.getNumOfPages());
        }
        Book tmp = library[0];
        library[0] = library[3];
        library[3] = tmp;
        System.out.println("---");
        for (Book book : library) {
            System.out.println(book.getName() + "-" + book.getNumOfPages());
        }
        System.out.println("---");
        for (Book book : library) {
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName() + "-" + book.getNumOfPages());
            }
        }
    }
}

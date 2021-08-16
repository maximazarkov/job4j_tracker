package ru.job4j.pojo;

//import java.time.LocalDateTime;

/*В замен примера из задания сдел свой для проработки будущего проекта*/
public class Product {
    private long id;
    private long skmtr;
    private String name;
    private String type;
//    private LocalDateTime release;  //перейти в будущем. уйти от стринг
    private String release;

    public Product(long id, long skmtr, String name, String type, String release) {
        this.id = id;
        this.skmtr = skmtr;
        this.name = name;
        this.type = type;
        this.release = release;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSkmtr() {
        return skmtr;
    }

    public void setSkmtr(long skmtr) {
        this.skmtr = skmtr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

}

package jav;

public class book {
    private String id;
    private jav.author author;
    private String title;
    private double price;


    public book(String id, author author, String title, double price) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.price = price;
    }

    public book() {
        this.id = id;
        this.author = author;
        this.title = title;
        this.price = price;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public jav.author getAuthor() {
        return author;
    }

    public void setAuthor(jav.author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public void output() {
        System.out.println("Title: " + title+"||___Author: " + author+" ||___Id: " + id+" ||___Price: " + price);

    }

}


package com.liuDay003;

public class BookDemo1 {
    private String title;
    private String author;
    private double price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public BookDemo1() {
    }

    public BookDemo1(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookDemo1{" +
                "书名='" + title + '\'' +
                ", 作者='" + author + '\'' +
                ", 价格=" + price +
                '}';
    }
}

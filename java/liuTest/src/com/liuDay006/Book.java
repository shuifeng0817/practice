package com.liuDay006;

class Book implements Comparable<Book>{
    private String title;
    private String author;
    private double price;
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    public String toString(){
        return title + "\t" + author + "\t" + price + "\n";
    }
    public int compareTo(Book o) {
        if(this.price > o.price) {
            return 1;
        }else if(this.price < o.price) {
            return -1;
        }else {
            if(this.title.compareTo(o.title) > 0) {
                return 1;
            }else if(this.title.compareTo(o.title) < 0) {
                return -1;
            }else {
                return this.author.compareTo(o.author);
            }
        }
    }

}

package com.LowLevelDesign.SystemDesign.Design.BehaviouralDesignPattern.Iterator_Dp;

import java.util.Arrays;
import java.util.List;

public class Iterator {
    public static void main(String[] args) {

        List<Book> bookList = Arrays.asList(
                new Book(100,"Science"),
                new Book(200,"OOPS"),
                new Book(300,"DSA"),
                new Book(400,"System Design"),
                new Book(500,"Solid Principal")
        );

        Library lib = new Library(bookList);
        Iterate iterate = lib.createIterator();

        while (iterate.hasNext()){
            Book book = (Book) iterate.next();
            System.out.println("Book name : " + book.getBookName() +" - " + book.getPrice() + " rs");
        }
    }
}

interface Iterate{
    boolean hasNext();
    Object next();
}

interface Aggregate{
    Iterate createIterator();
}

class Library{
    private List<Book> bookList;

    public Library(List<Book> bookList){
        this.bookList = bookList;
    }
    public Iterate createIterator(){
        return new BookIterater(bookList);
    }
}

class BookIterater implements Iterate{

    private List<Book> books;
    private int index = 0;

    public BookIterater(List<Book> books){
        this.books = books;
    }

    @Override
    public boolean hasNext() {
        return index < books.size();
    }

    @Override
    public Object next() {
        if(this.hasNext()){
            return books.get(index++);
        }
        return null;
    }
}

class Book{
    private int price;
    private String bookName;

    Book(int price, String bookName){
        this.price = price;
        this.bookName = bookName;
    }

    public int getPrice(){
        return price;
    }
    String getBookName(){
        return bookName;
    }
}


package com.twu.biblioteca.Model;

import java.util.ArrayList;

/**
 * Created by lbeier on 1/13/14.
 */
public class Book {
    private int id;
    private String title;
    private String author;
    private Customer customer;
    public ArrayList<Book> books = new ArrayList<Book>();

    public Book(){
        books.add(new Book(1, "Senhor dos anéis", "Tolkien", null));
        books.add(new Book(2, "Harry Potter", "Rowling", null));
        books.add(new Book(3, "1984", "Orwell", null));
    }

    public Book(int id, String title, String author, Customer customer) {
        this.setId(id);
        this.setTitle(title);
        this.setAuthor(author);
        this.setCustomer(customer);
    }

    public Book selectBook(int id) {
        Book selectedBook = books.get((id - 1));

        return selectedBook;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}

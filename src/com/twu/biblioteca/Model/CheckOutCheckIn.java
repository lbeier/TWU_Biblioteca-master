package com.twu.biblioteca.Model;

import java.util.*;

/**
 * Created by lbeier on 1/13/14.
 */
public class CheckOutCheckIn {
    private Book book;
    private Customer customer;

    public boolean checkOut() {
        Book selectedBook = this.getBook();
        Customer selectedCustomer = this.getCustomer();

        if (this.verifyIfBookIsAvailable()) {
            selectedBook.setCustomer(selectedCustomer);
            return true;
        } else {
            return false;
        }
    }

    public boolean verifyIfBookIsAvailable() {
        Book selectedBook = this.getBook();

        if (selectedBook.getCustomer() instanceof Customer) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkIn() {
        if(this.getBook().getCustomer().getId() == this.getCustomer().getId()) {
            this.getBook().setCustomer(null);
            return true;
        } else {
            return false;
        }
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

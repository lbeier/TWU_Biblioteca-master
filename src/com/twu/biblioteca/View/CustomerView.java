package com.twu.biblioteca.View;

import com.twu.biblioteca.Controller.CustomerController;
import com.twu.biblioteca.Model.Book;

import java.util.ArrayList;

/**
 * Created by lbeier on 1/12/14.
 */
public class CustomerView extends View {

    public void welcome() {
        write("Welcome, customer!");
    }

    public void listBooks(ArrayList<Book> books) {
        for(int i = 0; i < books.size(); i++) {
            Book book = books.get(i);

            write("====================");
            write("Id: "+ book.getId());
            write("Title: "+ book.getTitle());
            write("Author: "+ book.getAuthor());
            write("====================");
        }
    }

    public int mainMenu() {
        int option;

        write("====================");
        write("======MAIN MENU=====");
        write("Select an option:");
        write("1 - List all books");
        write("2 - Checkout book");
        write("3 - Return book");

        option = inputInt();

        return option;
    }

    public int inputBookId() {
        int bookId;

        write("Enter the book's id:");
        bookId = inputInt();

        return bookId;
    }

    public int inputCustomerId() {
        int customerId;

        write("Enter your id:");
        customerId = inputInt();

        return customerId;
    }

    public void invalidOption() {
        write("Select a valid option!");
    }

    public void successfulCheckout() {
        write("Thank you! Enjoy the book!");
    }

    public void unsuccessfulCheckout() {
        write("That book is not available.");
    }

    public void successfulCheckIn() {
        write("Thank you for returning the book.");
    }

    public void unsuccessfulCheckIn() {
        write("That is not a valid book to return.");
    }
}

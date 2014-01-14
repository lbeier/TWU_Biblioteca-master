package com.twu.biblioteca;

import com.twu.biblioteca.Controller.CustomerController;
import com.twu.biblioteca.Controller.LibrarianController;
import com.twu.biblioteca.Model.Book;
import com.twu.biblioteca.Model.CheckOutCheckIn;
import com.twu.biblioteca.Model.Customer;
import com.twu.biblioteca.View.CustomerView;
import com.twu.biblioteca.View.LibrarianView;

import java.io.IOException;
import java.util.Scanner;

public class BibliotecaApp {
    private final LibrarianController librarianController;
    private final CustomerController customerController;
    public Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        Book book = new Book();
        Customer customer = new Customer();
        CustomerView customerView = new CustomerView();
        CheckOutCheckIn checkOutCheckIn = new CheckOutCheckIn();

        LibrarianController librarianController = new LibrarianController();
        CustomerController customerController = new CustomerController(book, customer, customerView, checkOutCheckIn);

        new BibliotecaApp(librarianController, customerController).run();
    }

    public BibliotecaApp(LibrarianController librarianController, CustomerController customerController) {

        this.librarianController = librarianController;
        this.customerController = customerController;
    }

    public void run() {
        int option;

        System.out.println("What kind of person are you?");
        System.out.println("1 - Librarian");
        System.out.println("2 - Customer");
        option = keyboard.nextInt();

        while ((option != 1) &&  (option != 2)) {
            System.out.println("Invalid option. Please, select again.");
            option = keyboard.nextInt();
        }

        switch (option) {
            case 1:
                this.librarianController.run();
                this.run();
                break;
            case 2:
                this.customerController.run();
                this.run();
                break;
        }
    }
}
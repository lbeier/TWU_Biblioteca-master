package com.twu.biblioteca.Controller;

import com.twu.biblioteca.Model.Book;
import com.twu.biblioteca.Model.CheckOutCheckIn;
import com.twu.biblioteca.Model.Customer;
import com.twu.biblioteca.View.CustomerView;

/**
 * Created by lbeier on 1/12/14.
 */
public class CustomerController {
    private Book book;
    private Customer customer;
    private CustomerView customerView;
    private CheckOutCheckIn checkOutCheckIn;

    public CustomerController(Book book, Customer customer, CustomerView customerView, CheckOutCheckIn checkOutCheckIn) {
        this.book = book;
        this.customer = customer;
        this.customerView = customerView;
        this.checkOutCheckIn = checkOutCheckIn;
    }

    public void run() {
        int option;
        int customerId;
        int bookId;

        customerView.welcome();
        customerView.listBooks(this.book.books);
        option = customerView.mainMenu();

        while ((option < 1) || (option > 3)) {
            customerView.invalidOption();
            option = customerView.mainMenu();
        }

        switch (option) {
            case 1:
                customerView.listBooks(this.book.books);
                break;
            case 2:
                customerId = customerView.inputCustomerId();
                bookId = customerView.inputBookId();
                this.checkOut(bookId, customerId);
                this.run();
                break;
            case 3:
                customerId = customerView.inputCustomerId();
                bookId = customerView.inputBookId();
                this.checkIn(bookId, customerId);
                this.run();
                break;
        }
    }

    public void checkOut(int bookId, int customerId) {
        this.checkOutCheckIn.setBook(this.book.selectBook(bookId));
        this.checkOutCheckIn.setCustomer(this.customer.selectCustomer(customerId));

        if(this.checkOutCheckIn.checkOut()) {
            customerView.successfulCheckout();
        } else {
            customerView.unsuccessfulCheckout();
        }
    }

    public void checkIn(int bookId, int customerId) {
        this.checkOutCheckIn.setBook(this.book.selectBook(bookId));
        this.checkOutCheckIn.setCustomer(this.customer.selectCustomer(customerId));

        if(this.checkOutCheckIn.checkIn()) {
            customerView.successfulCheckIn();
        } else {
            customerView.unsuccessfulCheckIn();
        }
    }


}

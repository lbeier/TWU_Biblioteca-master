package com.twu.biblioteca.Controller;

import com.twu.biblioteca.Model.Book;
import com.twu.biblioteca.Model.CheckOutCheckIn;
import com.twu.biblioteca.Model.Customer;
import com.twu.biblioteca.View.CustomerView;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Created by lbeier on 1/12/14.
 */
public class CustomerControllerTest {

    private CustomerController customerController;
    private CustomerView customerViewMock;
    private Book bookMock;
    private Customer customerMock;
    private CheckOutCheckIn checkOutCheckInMock;


    @Before
    public void setUp() {
        customerViewMock = mock(CustomerView.class);
        bookMock = mock(Book.class);
        customerMock = mock(Customer.class);
        checkOutCheckInMock = mock(CheckOutCheckIn.class);

        customerController = new CustomerController(bookMock, customerMock, customerViewMock, checkOutCheckInMock);
    }

    @Test
    public void shouldShowWelcomeMessage() {
        when(customerViewMock.mainMenu()).thenReturn(1);

        customerController.run();

        verify(customerViewMock, atLeastOnce()).welcome();
    }

    @Test
    public void shouldListBooks() {
        when(customerViewMock.mainMenu()).thenReturn(1);

        customerController.run();

        verify(customerViewMock, atLeastOnce()).listBooks(bookMock.books);
    }

    @Test
    public void shouldShowMainMenu() {
        when(customerViewMock.mainMenu()).thenReturn(1);

        customerController.run();

        verify(customerViewMock, atLeastOnce()).mainMenu();
    }

    @Test
    public void shouldShowInvalidOptionMessage() {
        when(customerViewMock.mainMenu()).thenReturn(0).thenReturn(0).thenReturn(1);

        customerController.run();

        verify(customerViewMock, times(2)).invalidOption();

    }

    @Test
    public void shouldReceiveSuccessfulCheckoutMessage() {
        when(checkOutCheckInMock.checkOut()).thenReturn(true);

        customerController.checkOut(1, 1);

        verify(customerViewMock, atLeastOnce()).successfulCheckout();
    }

    @Test
    public void shouldReceiveUnsuccessfulCheckoutMessage() {
        when(checkOutCheckInMock.checkIn()).thenReturn(false);

        customerController.checkOut(1, 1);

        verify(customerViewMock, atLeastOnce()).unsuccessfulCheckout();
    }

    @Test
    public void shouldReceiveSuccessfulCheckInMessage() {
        when(checkOutCheckInMock.checkIn()).thenReturn(true);

        customerController.checkIn(1, 1);

        verify(customerViewMock, atLeastOnce()).successfulCheckIn();
    }

    @Test
    public void shouldReceiveUnsuccessfulCheckInMessage() {
        when(checkOutCheckInMock.checkIn()).thenReturn(false);

        customerController.checkIn(1, 1);

        verify(customerViewMock, atLeastOnce()).unsuccessfulCheckIn();
    }
}

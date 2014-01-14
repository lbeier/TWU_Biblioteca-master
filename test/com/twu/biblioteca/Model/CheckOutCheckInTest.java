package com.twu.biblioteca.Model;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * Created by lbeier on 1/14/14.
 */
public class CheckOutCheckInTest {
    private Book book;
    private Customer customer;
    private CheckOutCheckIn checkOutCheckIn;

    @Before
    public void setUp() {
        checkOutCheckIn = new CheckOutCheckIn();
        book = new Book().books.get(1);
        customer = new Customer(1, "Dumb test");

        checkOutCheckIn.setBook(book);
        checkOutCheckIn.setCustomer(customer);
    }

    @Test
    public void shouldVerifyThatBookIsAvailable()  {
        boolean successfulCheckout = checkOutCheckIn.verifyIfBookIsAvailable();

        assertTrue(successfulCheckout);
    }

    @Test
    public void shouldVerifyThatBookIsUnavailable()  {
        book.setCustomer(customer);
        boolean successfulCheckout = checkOutCheckIn.verifyIfBookIsAvailable();

        assertFalse(successfulCheckout);
    }

    @Test
    public void shouldCheckOutBook() {
        boolean checkOut = checkOutCheckIn.checkOut();

        assertTrue(checkOut);
    }

    @Test
    public void shouldNotCheckOutBook() {
        checkOutCheckIn.checkOut();
        boolean checkOut = checkOutCheckIn.checkOut();

        assertFalse(checkOut);
    }
}

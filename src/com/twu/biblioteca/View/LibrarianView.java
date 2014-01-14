package com.twu.biblioteca.View;

/**
 * Created by lbeier on 1/12/14.
 */
public class LibrarianView extends View {
    public void welcome() {
        write("Welcome, librarian!");
    }


    public void mainMenu() {
        write("Select an option:");
        write("1 - Checkout book");
    }
}

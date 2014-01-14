package com.twu.biblioteca.Controller;

import com.twu.biblioteca.View.LibrarianView;

/**
 * Created by lbeier on 1/12/14.
 */
public class LibrarianController {
    private LibrarianView librarianView = new LibrarianView();

    public void run() {
        librarianView.welcome();
        librarianView.mainMenu();
    }


}

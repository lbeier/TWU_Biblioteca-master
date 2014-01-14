package com.twu.biblioteca.View;

import sun.security.krb5.internal.ktab.KeyTabConstants;

import java.util.Scanner;

/**
 * Created by lbeier on 1/13/14.
 */
public class View {

    public static void write(String s) {
        System.out.println(s);
    }

    public static int inputInt() {
        Scanner keyboard = new Scanner(System.in);
        return keyboard.nextInt();
    }
}

package com.twu.biblioteca.Model;

import java.util.ArrayList;

/**
 * Created by lbeier on 1/12/14.
 */
public class Customer {

    private int id;
    private String name;

    public Customer() {}

    public Customer(int id, String name) {
        this.setId(id);
        this.setName(name);
    }

    public ArrayList<Customer> listOfCustomer() {
        ArrayList<Customer> customers = new ArrayList<Customer>() {{
            add(new Customer(1, "User 1"));
            add(new Customer(2, "User 2"));
            add(new Customer(3, "User 3"));
        }};

        return customers;
    }

    public Customer selectCustomer(int id) {
        Customer selectedCustomer = listOfCustomer().get((id - 1));

        return selectedCustomer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

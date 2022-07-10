package com.example;

import java.io.Serializable;

public class Customer implements Serializable {
    
    private String name;
    private String surName;
    private String ID;
    private String password;
    Account account;

    public Customer(String name, String surName, String ID, String password) {  // Constructor method
        this.name = name;
        this.surName = surName;
        this.ID = ID;
        this.password = password;

        String IBAN = "TR" + ID;                     // IBAN format: TR+ID
        this.account = new Account(0, 0, IBAN);
    }


    
    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getID() {
        return ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}

package com.example;

import java.io.Serializable;

public class Account implements Serializable{

    private int BalanceTL;                  // balance in turkish lira
    private int BalanceUSD;                 // balance in usd
    private String IBAN;
    static final int exchangeRate = 15;     //  1$ == 15TL



    public Account(int tl, int usd, String IBAN) {      // Constructor method
        this.BalanceTL = tl;
        this.BalanceUSD = usd;
        this.IBAN = IBAN;
    }

    

    public int getBalanceTL() {
        return BalanceTL;
    }
    

    public int getBalanceUSD() {
        return BalanceUSD;
    }

    public String getIBAN() {
        return IBAN;
    }

    public int getExchangerate() {
        return exchangeRate;
    }

    public void depositBalanceTL(int tl) {
        BalanceTL += tl;
    }

    public void depositBalanceUSD(int usd) {
        BalanceUSD += usd;
    }

    public void withdrawBalanceUSD(int usd) {
        BalanceUSD -= usd;
    }

    public void withdrawBalanceTL(int tl) {
        BalanceTL -= tl;
    }

    public void convertToUSD(int tl) {
        this.BalanceTL -= tl;
        this.BalanceUSD += (tl/exchangeRate);
    }

    public void convertToTL(int usd) {
        this.BalanceUSD -= usd;
        this.BalanceTL += (usd*exchangeRate);
    }

    
}

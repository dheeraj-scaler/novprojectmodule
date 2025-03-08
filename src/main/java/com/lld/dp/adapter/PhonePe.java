package com.lld.dp.adapter;

public class PhonePe {
    public static void main(String[] args) {
        // creating an adapter object
        BankApi bankAPI = new YesBankAdapter();

        String rajatAccNo = "1234";
        String sharmiliAccNo = "4321";

        double amount = 100.0;

        bankAPI.sendMoney(rajatAccNo, sharmiliAccNo, amount);
    }
}

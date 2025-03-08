package com.lld.dp.adapter;

public class YesBankAdapter implements BankApi {

    YesBankApi yesBankApi = new YesBankApi();

    @Override
    public double getBalance(String accountNumber) {
        return yesBankApi.findBal(accountNumber);
    }

    @Override
    public boolean sendMoney(String fromAcc, String toAcc, double amount) {
        return false;
    }
}
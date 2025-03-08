package com.lld.dp.adapter;

public interface BankApi {
    double getBalance(String accountNumber);

    boolean sendMoney(String fromAcc,
                      String toAcc,
                      double amount);
}

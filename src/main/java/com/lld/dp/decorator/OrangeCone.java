package com.lld.dp.decorator;

public class OrangeCone implements IceCream {

    @Override
    public int getCost() {
        return 20;
    }

    @Override
    public String getDescription() {
        return "orange cone";
    }
}
package com.lld.dp.factory.components.button;

public class IosButton implements Button{
    @Override
    public void showButton() {
        System.out.println("Showing ios Button");
    }

    @Override
    public void addBorderToButton() {
        System.out.println("Adding border to ios Button");
    }
}

package com.lld.dp.factory.components.button;

public class WindownButton implements Button {

    @Override
    public void showButton() {
        System.out.println("Showing windows Button");
    }

    @Override
    public void addBorderToButton() {
        System.out.println("Adding border to windows Button");
    }
}

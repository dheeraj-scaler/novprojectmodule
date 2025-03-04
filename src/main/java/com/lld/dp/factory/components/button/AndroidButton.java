package com.lld.dp.factory.components.button;

public class AndroidButton implements Button {
    @Override
    public void showButton() {
        System.out.println("Showing android Button");
    }

    @Override
    public void addBorderToButton() {
        System.out.println("Adding border to Android Button");
    }
}

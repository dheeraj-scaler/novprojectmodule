package com.lld.dp.factory.components.dropdown;

public class IosDropDown implements DropDown{
    @Override
    public void showDropDown() {
        System.out.println("Showing Ios dropdown");
    }

    @Override
    public void addDropDown() {
        System.out.println("Adding Ios dropdown");
    }
}

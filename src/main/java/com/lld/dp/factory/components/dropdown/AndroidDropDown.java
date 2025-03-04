package com.lld.dp.factory.components.dropdown;

public class AndroidDropDown implements DropDown {
    @Override
    public void showDropDown() {
        System.out.println("Showing Android dropdown");
    }

    @Override
    public void addDropDown() {
        System.out.println("Adding Android dropdown");
    }
}

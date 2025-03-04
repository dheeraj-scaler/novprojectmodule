package com.lld.dp.factory.components.dropdown;

public class WindowsDropdown implements DropDown{
    @Override
    public void showDropDown() {
        System.out.println("Showing windows dropdown");
    }

    @Override
    public void addDropDown() {
        System.out.println("Adding windows dropdown");
    }
}

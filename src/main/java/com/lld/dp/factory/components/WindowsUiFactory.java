package com.lld.dp.factory.components;

import com.lld.dp.factory.components.button.Button;
import com.lld.dp.factory.components.button.WindownButton;
import com.lld.dp.factory.components.dropdown.DropDown;
import com.lld.dp.factory.components.dropdown.WindowsDropdown;

public class WindowsUiFactory implements UiFactory{

    @Override
    public Button createButton() {
        return new WindownButton();
    }

    @Override
    public DropDown createDropDown() {
        return new WindowsDropdown();
    }
}

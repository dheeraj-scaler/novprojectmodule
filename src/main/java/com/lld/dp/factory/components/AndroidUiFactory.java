package com.lld.dp.factory.components;

import com.lld.dp.factory.components.button.AndroidButton;
import com.lld.dp.factory.components.button.Button;
import com.lld.dp.factory.components.dropdown.AndroidDropDown;
import com.lld.dp.factory.components.dropdown.DropDown;

public class AndroidUiFactory implements UiFactory{
    @Override
    public Button createButton() {
        return new AndroidButton();
    }

    @Override
    public DropDown createDropDown() {
        return new AndroidDropDown();
    }
}

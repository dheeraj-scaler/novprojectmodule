package com.lld.dp.factory.components;

import com.lld.dp.factory.components.button.Button;
import com.lld.dp.factory.components.button.IosButton;
import com.lld.dp.factory.components.dropdown.DropDown;
import com.lld.dp.factory.components.dropdown.IosDropDown;

public class IosUiFactory implements UiFactory{

    @Override
    public Button createButton() {
        return new IosButton();
    }

    @Override
    public DropDown createDropDown() {
        return new IosDropDown();
    }
}

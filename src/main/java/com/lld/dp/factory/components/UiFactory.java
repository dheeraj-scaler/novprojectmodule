package com.lld.dp.factory.components;

import com.lld.dp.factory.components.button.Button;
import com.lld.dp.factory.components.dropdown.DropDown;

// This interface contains factory methods
public interface UiFactory {
    Button createButton();
    DropDown createDropDown();
}

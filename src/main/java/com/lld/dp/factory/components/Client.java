package com.lld.dp.factory.components;

import com.lld.dp.factory.components.button.Button;
import com.lld.dp.factory.components.dropdown.DropDown;

public class Client {

    public static void main(String[] args) {
//        Flutter flutter = new Flutter();
//        UiFactory uiFactory = flutter.getFactory(SupportedPlatform.IOS);
//
//        Button button = uiFactory.createButton();
//        button.clickButton();
//
//        DropDown dropDown = uiFactory.createDropDown();
//        dropDown.clickDropDown();



        String input = "";
        Flutter flutter = new Flutter();

       UiFactory uiFactory = flutter.getFactory(SupportedPlatform.ANDROID);

       Button button = uiFactory.createButton();
       button.showButton();

    }
}

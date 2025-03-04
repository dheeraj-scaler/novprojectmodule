package com.lld.dp.factory.components;

public class Flutter {


    // refreshUI and setTheme are platform independant
    // that's why Flutter is a class and not an interface
    void refreshUI() {
        System.out.println("Refreshing the UI");
    }

    void setTheme() {
        System.out.println(" Setting the theme");
    }

    public UiFactory getFactory(SupportedPlatform platformName) {
        return UiFactoryFactory.getUiFactoryUsingPlatformName(platformName);
    }

//    public UiFactory getFactory(SupportedPlatform platform) {
//        if(platform.equals(SupportedPlatform.ANDROID)) {
//            return new AndroidUiFactory();
//        }
//        else if(platform.equals(SupportedPlatform.IOS)) {
//            return new IosUiFactory();
//        }
//        return new WindowsUiFactory();
//    }
}

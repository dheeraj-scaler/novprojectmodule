package com.lld.dp.decorator;

public class VanillaScoop implements IceCream {

    IceCream iceCream;

    public VanillaScoop(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    @Override
    public int getCost() {
        return iceCream.getCost() + 10;
    }

    @Override
    public String getDescription() {
        return iceCream.getDescription() + "vanilla scoop";
    }
}
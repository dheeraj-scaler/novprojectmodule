package com.lld.dp.decorator;

public class Client {
    public static void main(String[] args) {
//        IceCream iceCream =
//                new ChocoChips(
//                        new StrawberryScoop(
//                                new ChocolateCone(
//                                        new ChocoChips(
//                                                new OrangeCone()
//                                        )
//                                )
//                        )
//                );

//        System.out.println(iceCream.getDescription());
//        System.out.println(iceCream.getCost());

        IceCream ic = new OrangeCone();
        ic = new ChocoChips(ic);
        ic = new ChocolateCone(ic);

        IceCream ic1 = new ChocolateCone(
                new ChocoChips(
                        new OrangeCone()
                )
        );

        System.out.println(ic1.getDescription());
    }
}
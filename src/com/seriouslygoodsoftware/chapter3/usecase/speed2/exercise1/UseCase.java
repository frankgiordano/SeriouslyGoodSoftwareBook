package com.seriouslygoodsoftware.chapter3.usecase.speed2.exercise1;

public class UseCase {

    public static void main(String args[]) {
        System.out.println("use case with ContainerV1...");
        ContainerV1 a = new ContainerV1();
        ContainerV1 b = new ContainerV1();
        ContainerV1 c = new ContainerV1();
        ContainerV1 d = new ContainerV1();

        a.addWater(12);
        d.addWater(8);
        a.connectTo(b);
        System.out.println(a.getAmount() + " " + b.getAmount() + " " + c.getAmount() + " " + d.getAmount());
        b.connectTo(c);
        System.out.println(a.getAmount() + " " + b.getAmount() + " " + c.getAmount() + " " + d.getAmount());
        b.connectTo(d);
        System.out.println(a.getAmount() + " " + b.getAmount() + " " + c.getAmount() + " " + d.getAmount());
        System.out.println(a.groupSize());

        System.out.println("use case with ContainerV2...");
        ContainerV2 a2 = new ContainerV2();
        ContainerV2 b2 = new ContainerV2();
        ContainerV2 c2 = new ContainerV2();
        ContainerV2 d2 = new ContainerV2();

        a2.addWater(12);
        d2.addWater(8);
        a2.connectTo(b2);
        System.out.println(a2.getAmount() + " " + b2.getAmount() + " " + c2.getAmount() + " " + d2.getAmount());
        b2.connectTo(c2);
        System.out.println(a2.getAmount() + " " + b2.getAmount() + " " + c2.getAmount() + " " + d2.getAmount());
        b2.connectTo(d2);
        System.out.println(a2.getAmount() + " " + b2.getAmount() + " " + c2.getAmount() + " " + d2.getAmount());
        System.out.println(a2.groupSize());
    }

}

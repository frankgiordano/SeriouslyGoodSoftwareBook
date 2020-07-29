package com.seriouslygoodsoftware.chapter3.usecase.exercise3a;

/**
 * Design two classes, Grid and Appliance, representing an electrical grid and an appliance that the
 * grid can power. Each grid (or each appliance) is characterized by the maximum power it provides
 * (or absorbs). You can connect an appliance to a grid using the plugInto method, and you can turn
 * it on and off using the on and off instance methods. (Initially, any new appliance is turned off.)
 * Connecting an appliance to another grid automatically disconnects it from the first one. If turning
 * an appliance on overloads its grid, the method on must throw an exception. Finally, the
 * residualPower method of Grid returns the power that’s still available on this grid.
 */
public class PowerGridUsage {

    public static void main(String[] args) {
        Appliance tv = new Appliance(150);
        Appliance radio = new Appliance(30);
        Appliance desktop = new Appliance(1000);
        Appliance laptop = new Appliance(1000);
        Grid grid = new Grid(3000);

        tv.plugInto(grid);
        radio.plugInto(grid);
        desktop.plugInto(grid);
        laptop.plugInto(grid);
        try {
            System.out.println(grid.residualPower());
            tv.on();
            System.out.println(grid.residualPower());
            radio.on();
            System.out.println(grid.residualPower());
            desktop.on();
            System.out.println(grid.residualPower());
            laptop.on();
            System.out.println(grid.residualPower());
            laptop.off();
            System.out.println(grid.residualPower());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

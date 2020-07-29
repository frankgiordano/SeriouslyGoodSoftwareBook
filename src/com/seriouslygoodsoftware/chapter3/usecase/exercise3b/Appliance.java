package com.seriouslygoodsoftware.chapter3.usecase.exercise3b;

public class Appliance {

    private long powerUsage;
    private Grid grid;
    private boolean isOn = false;

    public Appliance(long powerUsage) {
        this.powerUsage = powerUsage;
    }

    public void plugInto(Grid grid) throws Exception {
        // check if there is a grid already plugged in
        // to this Appliance, before disconnecting it,
        // return the gird's appliance power usage..
        if (grid != null && isOn) {
            this.grid.addPower(this.powerUsage);
        }
        this.grid = grid;
        if (isOn) {
            this.grid.usePower(powerUsage);
        }
    }

    public void on() throws Exception {
        if (grid == null)
            throw new IllegalStateException("Cannot turn on when unconnected to any grid.");
        if (!isOn) {
            this.grid.usePower(this.powerUsage);
            isOn = true;
        }
    }

    public void off() {
        if (this.grid != null && isOn) {
            this.grid.addPower(this.powerUsage);
            isOn = false;
        }
    }

}

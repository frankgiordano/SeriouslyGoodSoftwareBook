package com.seriouslygoodsoftware.chapter3.usecase.exercise3a;

public class Appliance {

    private long powerUsage;
    private Grid grid;
    private boolean isOn = false;

    public Appliance(long powerUsage) {
        this.powerUsage = powerUsage;
    }

    public void plugInto(Grid grid) {
        this.grid = grid;
        this.grid.connectTo(this);
    }

    public void on() throws Exception {
        this.isOn = true;
        if (this.grid != null)
          this.grid.residualPower();
    }

    public void off() {
        this.isOn = false;
    }

    public long getPowerUsage() {
        return powerUsage;
    }

    public boolean isOn() {
        return isOn;
    }

}

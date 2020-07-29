package com.seriouslygoodsoftware.chapter3.usecase.exercise3b;

public class Grid {

    private final long maxPower;
    private long powerUsage;

    public Grid(long maxPower) {
        this.maxPower = maxPower;
        this.powerUsage = maxPower;
    }

    public long residualPower() throws Exception {
        return this.powerUsage;
    }

    public void usePower(long power) throws Exception {
        if (this.powerUsage - power < 0)
            throw new Exception("Grid Overloaded");

        this.powerUsage -= power;
    }

    public void addPower(long power) {
        if (this.powerUsage + power > this.maxPower) {
            throw new IllegalArgumentException("Maximum power exceeded.");
        }
        if (this.powerUsage + power < 0) {
            throw new IllegalArgumentException("Not enough power.");
        }
        this.powerUsage += power;
    }

}

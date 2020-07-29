package com.seriouslygoodsoftware.chapter3.usecase.exercise3a;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    private long totalPower;
    private List<Appliance> applianceList = new ArrayList<Appliance>();

    public Grid(long totalPower) {
        this.totalPower = totalPower;
    }

    public long residualPower() throws Exception {
        long powerUsage = this.totalPower;
        for (Appliance a: applianceList) {
            if (a.isOn())
                powerUsage -= a.getPowerUsage();
        }
        if (powerUsage < 0)
            throw new Exception("Grid Overloaded");
        return powerUsage;
    }

    public void connectTo(Appliance appliance) {
        applianceList.add(appliance);
    }

}

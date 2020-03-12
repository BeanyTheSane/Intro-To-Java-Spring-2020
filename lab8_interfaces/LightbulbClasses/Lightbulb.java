package LightbulbClasses;

import Interfaces.AcPoweredDevices;

public class Lightbulb implements AcPoweredDevices {
    private int wattage;
    final private String type = "Lightbulb";

    public Lightbulb(int wattage) {
        this.wattage = wattage;
    }

    public int getWattage() {
        return this.wattage;
    }

    public void setWattage(int wattage) {
        this.wattage = wattage;
    }

    public String getType() {
        return this.type;
    }
    
    public Double getKWH() {
        return Double.valueOf(this.wattage) / 1000;
    }
    
    public String toString() {
        return this.getType() + ", " + this.getWattage() + " Watts";
    }

}
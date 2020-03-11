package ComputerClasses;

import Interfaces.AcPoweredDevices;

public class Laptop extends Computer implements AcPoweredDevices {
    final private Double kwHConstant = 0.06;

    Laptop() {
        super("Laptop");
    }

    @Override
    public Double getKWH() {
        return this.kwHConstant;
    }
    
    @Override
    public String toString() {
        return this.getParentType() + ", " + this.getType();
    }

}
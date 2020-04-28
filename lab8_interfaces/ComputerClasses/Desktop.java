package ComputerClasses;

import Interfaces.AcPoweredDevices;

public class Desktop extends Computer implements AcPoweredDevices {
    final private Double kwHConstant = 0.175;

    public Desktop() {
        super("Deskptop");
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
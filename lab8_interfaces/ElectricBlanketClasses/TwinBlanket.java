package ElectricBlanketClasses;

import Interfaces.AcPoweredDevices;

public class TwinBlanket extends ElectricBlanket implements AcPoweredDevices {
    final private Double kwHConstant = 100.00;

    TwinBlanket() {
        super(10.00, "Twin");//blanket setting is defaulted to 10
    }

    @Override
    public Double getKWH() {
        return (this.kwHConstant * this.getSetting() / 10) / 1000;
    }
    
    @Override
    public String toString() {
        return this.getParentType() + ", " + this.getSize() + "at " + this.getSetting();
    }
    
}
package ElectricBlanketClasses;

import Interfaces.AcPoweredDevices;

public class KingBlanket extends ElectricBlanket implements AcPoweredDevices {
    final private Double kwHConstant = 200.00;

    KingBlanket() {
        super(10.00, "King");//blanket setting is defaulted to 10
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
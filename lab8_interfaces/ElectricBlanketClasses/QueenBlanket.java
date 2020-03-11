package ElectricBlanketClasses;

import Interfaces.AcPoweredDevices;

public class QueenBlanket extends ElectricBlanket implements AcPoweredDevices {
    final private Double kwHConstant = 150.00;

    QueenBlanket() {
        super(10.00, "Queen");//blanket setting is defaulted to 10
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
package TvClasses;

import Interfaces.AcPoweredDevices;

public class TubeTv extends Television implements AcPoweredDevices {
    final private Double kwHConstantLarge = 0.12;
    final private Double kwHConstantSmall = 0.09;

    public TubeTv(int sizeInInches) {
        super("Tube TV", sizeInInches);
    }

    @Override
    public Double getKWH() {
        Double returnKwH = this.getSizeInInches() > 30 ? this.kwHConstantLarge : this.kwHConstantSmall; 
        return returnKwH;
    }
    
    @Override
    public String toString() {
        return this.getParentType() + ", " + this.getType() + " " + this.getSizeInInches() + " inches";
    }

}
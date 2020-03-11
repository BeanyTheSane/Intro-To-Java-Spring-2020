package TvClasses;

import Interfaces.AcPoweredDevices;

public class PlasmaTv extends Television implements AcPoweredDevices {
    final private Double kwHConstantLarge = 0.48;
    final private Double kwHConstantSmall = 0.4;

    PlasmaTv(int sizeInInches) {
        super("Plasma TV", sizeInInches);
    }

    @Override
    public Double getKWH() {
        Double returnKwH = this.getSizeInInches() > 50 ? this.kwHConstantLarge : this.kwHConstantSmall; 
        return returnKwH;
    }
    
    @Override
    public String toString() {
        return this.getParentType() + ", " + this.getType() + " " + this.getSizeInInches() + " inches";
    }

}
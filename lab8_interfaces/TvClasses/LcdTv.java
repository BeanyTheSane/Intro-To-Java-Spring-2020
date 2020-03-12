package TvClasses;

import Interfaces.AcPoweredDevices;

public class LcdTv extends Television implements AcPoweredDevices {
    final private Double kwHConstantLarge = 0.016;
    final private Double kwHConstantSmall = 0.012;

    public LcdTv(int sizeInInches) {
        super("LCD TV", sizeInInches);
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
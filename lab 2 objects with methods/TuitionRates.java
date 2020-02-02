public class TuitionRates {
    
    final static Double inCountyBaseRate = 139.04;
    final static Double outOfCountyBaseRate = 164.22;
    final static Double outOfStateBaseRate = 315.79;
    final static int creditHourBonusRate = 13;
    final static int creditHourBonusRateOffset = 5;

    public static int getCreditHourBonusRateOffset() {
        return creditHourBonusRateOffset;
    }

    public static int getCreditHourBonusRate() {
        return creditHourBonusRate;
    }

    public static Double getInCountyBaseRate() {
        return inCountyBaseRate;
    }

    public static Double getOutOfCountyBaseRate() {
        return outOfCountyBaseRate;
    }

    public static Double getOutOfStateBaseRate() {
        return outOfStateBaseRate;
    } 

}
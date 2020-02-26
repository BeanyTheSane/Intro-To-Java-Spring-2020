import java.math.BigDecimal;

public class TuitionRates {
    
    final static BigDecimal inCountyBaseRate = BigDecimal.valueOf(139.04);
    final static BigDecimal outOfCountyBaseRate = BigDecimal.valueOf(164.22);
    final static BigDecimal outOfStateBaseRate = BigDecimal.valueOf(315.79);
    final static int creditHourBonusRate = 13;
    final static int creditHourBonusRateOffset = 5;

    public static int getCreditHourBonusRateOffset() {
        return creditHourBonusRateOffset;
    }

    public static int getCreditHourBonusRate() {
        return creditHourBonusRate;
    }

    public static BigDecimal getInCountyBaseRate() {
        return inCountyBaseRate;
    }

    public static BigDecimal getOutOfCountyBaseRate() {
        return outOfCountyBaseRate;
    }

    public static BigDecimal getOutOfStateBaseRate() {
        return outOfStateBaseRate;
    } 

}
package ElectricBlanketClasses;

import java.math.BigDecimal;

public abstract class ElectricBlanket {
    private BigDecimal setting;
    private String size;


    public BigDecimal getSetting() {
        return this.setting;
    }

    public void setSetting(BigDecimal setting) {
        this.setting = setting;
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String size) {
        this.size = size;
    }

}
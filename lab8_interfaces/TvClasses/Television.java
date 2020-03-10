package TvClasses;

import java.math.BigDecimal;

public class Television {
    private String type;
    private BigDecimal sizeInInches;


    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getSizeInInches() {
        return this.sizeInInches;
    }

    public void setSizeInInches(BigDecimal sizeInInches) {
        this.sizeInInches = sizeInInches;
    }

}
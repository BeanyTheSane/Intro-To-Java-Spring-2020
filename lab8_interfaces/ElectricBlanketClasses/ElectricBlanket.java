package ElectricBlanketClasses;

public abstract class ElectricBlanket {
    private Double setting;
    private String size;
    final private String parentType = "Electric Blanket";

    public ElectricBlanket(Double setting, String size) {
        this.setting = setting;
        this.size = size;
    }

    public Double getSetting() {
        return this.setting;
    }

    public void setSetting(Double setting) {
        this.setting = setting;
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getParentType() {
        return this.parentType;
    }

}
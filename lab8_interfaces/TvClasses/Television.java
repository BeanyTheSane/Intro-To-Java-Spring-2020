package TvClasses;

public abstract class Television {
    private String type;
    private int sizeInInches;
    final private String parentType = "Television";

    public Television(String type, int sizeInInches) {
        this.type = type;
        this.sizeInInches = sizeInInches;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSizeInInches() {
        return this.sizeInInches;
    }

    public void setSizeInInches(int sizeInInches) {
        this.sizeInInches = sizeInInches;
    }

    public String getParentType() {
        return this.parentType;
    }

}
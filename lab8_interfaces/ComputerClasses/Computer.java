package ComputerClasses;

public abstract class Computer {
    private String type;
    final private String parentType = "Computer";

    public Computer(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParentType() {
        return this.parentType;
    }

}
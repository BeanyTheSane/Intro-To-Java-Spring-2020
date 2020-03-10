package ComputerClasses;

import Interfaces.AcPoweredDevices;

public class Desktop extends Computer implements AcPoweredDevices {

    Desktop() {
        super("deskptop");
    }

    @Override
    public Double getKWH() {
        return null;
    }
    
    @Override
    public String toString() {
        return "";
    }

}
package UnitTests;

import java.util.ArrayList;
import java.util.Scanner;

import ComputerClasses.Desktop;
import ComputerClasses.Laptop;
import ElectricBlanketClasses.KingBlanket;
import ElectricBlanketClasses.QueenBlanket;
import ElectricBlanketClasses.TwinBlanket;
import Interfaces.AcPoweredDevices;
import LightbulbClasses.Lightbulb;
import TvClasses.LcdTv;
import TvClasses.PlasmaTv;
import TvClasses.TubeTv;

public class UnitTest {
    

    public static void main(String[] arg){
        ArrayList<AcPoweredDevices> deviceList = new ArrayList<>();
        Desktop desktop = new Desktop();
        Laptop laptop = new Laptop();
        KingBlanket kingBlanket01 = new KingBlanket(1.0);
        KingBlanket kingBlanket04 = new KingBlanket(4.0);
        KingBlanket kingBlanket07 = new KingBlanket(7.0);
        KingBlanket kingBlanket10 = new KingBlanket();
        QueenBlanket queenBlanket02 = new QueenBlanket(2.0);
        QueenBlanket queenBlanket05 = new QueenBlanket(5.0);
        QueenBlanket queenBlanket08 = new QueenBlanket(8.0);
        TwinBlanket twinBlanket03 = new TwinBlanket(3.0);
        TwinBlanket twinBlanket06 = new TwinBlanket(6.0);
        TwinBlanket twinBlanket09 = new TwinBlanket(9.0);
        Lightbulb lightbulb40 = new Lightbulb(40);
        Lightbulb lightbulb60 = new Lightbulb(60);
        Lightbulb lightbulb100 = new Lightbulb(100);
        LcdTv lcdTvLarge = new LcdTv(65);
        LcdTv lcdTvSmall = new LcdTv(32);
        PlasmaTv plasmaTvLarge = new PlasmaTv(65);
        PlasmaTv plasmaTvSmall = new PlasmaTv(32);
        TubeTv tubeTvLarge = new TubeTv(32);
        TubeTv tubeTvSmall = new TubeTv(16);
        int fiveAtaTime = 0;
        final Scanner myScanner = new Scanner(System.in);

        deviceList.add(desktop);
        deviceList.add(laptop);
        deviceList.add(kingBlanket01);
        deviceList.add(kingBlanket04);
        deviceList.add(kingBlanket07);
        deviceList.add(kingBlanket10);
        deviceList.add(queenBlanket02);
        deviceList.add(queenBlanket05);
        deviceList.add(queenBlanket08);
        deviceList.add(twinBlanket03);
        deviceList.add(twinBlanket06);
        deviceList.add(twinBlanket09);
        deviceList.add(lightbulb40);
        deviceList.add(lightbulb60);
        deviceList.add(lightbulb100);
        deviceList.add(lcdTvLarge);
        deviceList.add(lcdTvSmall);
        deviceList.add(plasmaTvLarge);
        deviceList.add(plasmaTvSmall);
        deviceList.add(tubeTvLarge);
        deviceList.add(tubeTvSmall);

        for (AcPoweredDevices device : deviceList) {
            System.out.println("> " + device.toString());
            System.out.println("    KwH: " + device.getKWH() + "\n");
            fiveAtaTime += 1;
            if (fiveAtaTime == 5) {
                System.out.println("Press Enter to Continue");
                myScanner.nextLine();
                fiveAtaTime = 0;
            }
        }

        System.out.println("Press Enter to Continue");
        myScanner.nextLine();
        myScanner.close();
    }
}
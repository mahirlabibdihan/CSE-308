package builder;

import product.PC;
import product.part.GraphicsCard;
import product.part.HDD;
import product.part.MotherBoard;
import product.part.RAM;

import java.util.Scanner;

// 3 types of components
// Common + Not customizable
// Uncommmon + Not customizable
// Common + Customizable
public abstract class PCBuilder {
    private Scanner sc = new Scanner(System.in);
    protected PC pc;

    public void addHDD() {
        pc.addBaseComponent(new HDD("1 TB"));
    }

    public void addMotherBoard() {
        pc.addBaseComponent(new MotherBoard());
    }

    public abstract boolean addCPU();

    public abstract boolean addDVDDrive();

    public abstract boolean addCPUCooler();

    public abstract boolean addLiquidCooler();

    // Make general class for addition
    public void addRam() {
        System.out.println("1. 8GB DDR4 2666MHz RAM - 2620 BDT");
        System.out.println("2. 8GB DDR4 3200MHz RAM - 2950 BDT");
        System.out.print("Choose one RAM[1/2]: ");
        String opn = sc.nextLine();
        switch (opn) {
            case "1":
                pc.addAdditionalComponent(new RAM("8GB", "DDR4", "2666MHZ", 2620));
                break;
            case "2":
                pc.addAdditionalComponent(new RAM("8GB", "DDR4", "3200MHZ", 2950));
                break;
            default:
                break;
        }
    }

    public void addGraphicsCard() {
        System.out.println("1. 2GB Graphics Card - 6500 BDT");
        System.out.println("2. 4GB Graphics Card - 7600 BDT");
        System.out.print("Choose one Graphics Card[1/2]: ");
        String opn = sc.nextLine();
        switch (opn) {
            case "1":
                pc.addAdditionalComponent(new GraphicsCard("2GB", 6500));
                break;
            case "2":
                pc.addAdditionalComponent(new GraphicsCard("4GB", 7600));
                break;
            default:
                break;
        }
    }

    public PC getPc() {
        return pc;
    }
}



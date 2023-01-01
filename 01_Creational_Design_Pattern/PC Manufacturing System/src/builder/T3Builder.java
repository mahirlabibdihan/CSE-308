package builder;

import product.PC;
import product.part.DVDDrive;
import product.part.cpu.AMD;
import product.part.cpu.Intel;

import java.util.Scanner;

public class T3Builder extends PCBuilder {
    private Scanner sc = new Scanner(System.in);
    public T3Builder() {
        pc = new PC("Core i9 PC",70000);
    }

    @Override
    public boolean addCPU() {
        System.out.println("Adding Intel Core i9 11th Generation Processor - Price: 65,000 BDT");
        System.out.println("Do you want to continue?[y/n] :");
        String ans = sc.nextLine();
        if (ans.equalsIgnoreCase("y")) {
            pc.addAdditionalComponent(new Intel("Core i9", "11th", 65000));
            return true;
        }
        return false;
    }

    @Override
    public boolean addCPUCooler() {
        /* Do nothing */
        return true;
    }

    @Override
    public boolean addLiquidCooler() {
        /* Do nothing */
        return true;
    }

    @Override
    public boolean addDVDDrive() {
        System.out.println("Adding DVD Drive - Price: 6,000 BDT");
        System.out.println("Do you want to continue?[y/n] :");
        String ans = sc.nextLine();
        if (ans.equalsIgnoreCase("y")) {
            pc.addAdditionalComponent(new DVDDrive(6000));
            return true;
        }
        return false;
    }
}

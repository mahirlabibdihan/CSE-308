package builder;

import product.PC;
import product.part.*;
import product.part.cpu.Intel;

import java.util.Scanner;

public class T1Builder extends PCBuilder {
    private Scanner sc = new Scanner(System.in);

    public T1Builder() {
        pc = new PC("Core i5 PC", 70000);
    }

    @Override
    public boolean addCPU() {
        System.out.println("Adding Intel Core i5 11th Generation Processor - Price: 20,000 BDT");
        System.out.println("Do you want to continue?[y/n] :");
        String ans = sc.nextLine();
        if (ans.equalsIgnoreCase("y")) {
            pc.addAdditionalComponent(new Intel("Core i5", "11th", 20000));
            return true;
        }
        return false;
    }

    @Override
    public boolean addCPUCooler() {
        System.out.println("Adding CPU Cooler - Price: 36,000 BDT");
        System.out.println("Do you want to continue?[y/n] :");
        String ans = sc.nextLine();
        if (ans.equalsIgnoreCase("y")) {
            pc.addAdditionalComponent(new CPUCooler(36000));
            return true;
        }
        return false;
    }

    @Override
    public boolean addLiquidCooler() {
        /* Do nothing */
        return true;
    }

    @Override
    public boolean addDVDDrive() {
        /* Do nothing */
        return true;
    }
}

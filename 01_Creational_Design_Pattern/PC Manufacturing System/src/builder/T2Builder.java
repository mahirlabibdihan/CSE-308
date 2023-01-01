package builder;

import product.PC;
import product.part.LiquidCooler;
import product.part.cpu.Intel;

import java.util.Scanner;

public class T2Builder extends PCBuilder {
    private Scanner sc = new Scanner(System.in);
    public T2Builder() {
        pc = new PC("Core i7 PC",70000);
    }

    @Override
    public boolean addCPU() {
        System.out.println("Adding Intel Core i7 11th Generation Processor - Price: 37,000 BDT");
        System.out.println("Do you want to continue?[y/n] :");
        String ans = sc.nextLine();
        if (ans.equalsIgnoreCase("y")) {
            pc.addAdditionalComponent(new Intel("Core i7", "11th", 37000));
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
        System.out.println("Adding LiquidCooler - Price: 17,000 BDT");
        System.out.println("Do you want to continue?[y/n] :");
        String ans = sc.nextLine();
        if (ans.equalsIgnoreCase("y")) {
            pc.addAdditionalComponent(new LiquidCooler(17000));
            return true;
        }
        return false;
    }

    @Override
    public boolean addDVDDrive() {
        /* Do nothing */
        return true;
    }
}

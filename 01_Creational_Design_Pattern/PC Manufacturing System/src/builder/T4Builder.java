package builder;

import product.PC;
import product.part.CPUCooler;
import product.part.cpu.AMD;

import java.util.Scanner;

public class T4Builder extends PCBuilder {
    private Scanner sc = new Scanner(System.in);
    public T4Builder() {
        pc = new PC("Gaming PC",70000);
    }

    @Override
    public boolean addCPU() {
        System.out.println("Adding AMD Ryzen 7 5700X Processor - Price: 28,000 BDT");
        System.out.println("Do you want to continue?[y/n] :");
        String ans = sc.nextLine();
        if (ans.equalsIgnoreCase("y")) {
            pc.addAdditionalComponent(new AMD("Ryzen 7", "5700X", 28000));
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
        /* Do nothing */
        return true;
    }
}

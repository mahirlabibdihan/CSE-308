package director;

import builder.PCBuilder;
import product.part.RAM;

import java.util.Scanner;

public class PCManufacturer {
    private Scanner sc = new Scanner(System.in);

    public boolean buildPC(PCBuilder builder) {
        builder.addMotherBoard();
        builder.addHDD();
        System.out.println("Base PC is built");
        if (!builder.addCPU()) return false;
        if (!builder.addCPUCooler()) return false;
        if (!builder.addLiquidCooler()) return false;
        if (!builder.addDVDDrive()) return false;

        while (true) {
            System.out.println("You can customize some components or add PC to cart");
            System.out.println("1. Add RAM");
            System.out.println("2. Add Graphics Card");
            System.out.println("3. Add to cart");
            System.out.print("Choose option[1/2/3]: ");
            String opn = sc.nextLine();
            if (opn.equalsIgnoreCase("1")) {
                builder.addRam();
            }
            else if(opn.equalsIgnoreCase("2")){
                builder.addGraphicsCard();
            }
            else if(opn.equalsIgnoreCase("3")){
                break;
            }
            else {
                System.out.println("Error: Invalid option");
            }
        }
        return true;
    }
}
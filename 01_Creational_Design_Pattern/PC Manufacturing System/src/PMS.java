import builder.PCBuilder;
import creator.PCBuilderCreator;
import director.PCManufacturer;
import product.PC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PMS {
    private static Scanner sc = new Scanner(System.in);
    private static PCBuilderCreator creator = new PCBuilderCreator();

    public static void handleOrder(List<PC> pcs) {
        while (true) {
            System.out.println("1. Core i5 PC - Base price: 70,000 BDT");
            System.out.println("2. Core i7 PC - Base price: 70,000 BDT");
            System.out.println("3. Core i9 PC - Base price: 70,000 BDT");
            System.out.println("4. Gaming PC - Base price: 70,000 BDT");
            System.out.print("Choose one PC[1/2/3/4]: ");
            String type = sc.nextLine();
            try {
                PCBuilder builder = creator.createBuilder(type);
                PCManufacturer director = new PCManufacturer();
                if (director.buildPC(builder)) {
                    pcs.add(builder.getPc());
                    System.out.println("PC added to cart");
                }
                break;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        List<PC> pcs = new ArrayList<>();
        boolean order_running = false;
        System.out.println("Welcome to PC Manufacturing System:)");
        while (true) {
            System.out.print("Press any key: ");
            String key = sc.nextLine();
            if (key.equalsIgnoreCase("O")) {   // Open order
                if (!order_running) {
                    order_running = true;
                    System.out.println("New order opened");
                    handleOrder(pcs);
                } else {
                    System.out.println("Error: Current order ongoing");
                    System.out.print("Want to buy another PC?[y/n]: ");
                    String ans = sc.nextLine();
                    if (ans.equalsIgnoreCase("y")) {
                        handleOrder(pcs);
                    }
                }
            } else if (key.equalsIgnoreCase("E")) {
                if (!order_running) {
                    System.out.println("Error: No order ongoing");
                } else if (pcs.isEmpty()) {
                    System.out.println("Error: Empty cart");
                } else {
                    order_running = false;
                    System.out.println("Order placed"); // Exit order
                    for (PC pc : pcs) {
                        pc.printReceipt();
                    }
                }
            } else if (key.equalsIgnoreCase("Q")) {
                break;
            } else {
                if (order_running) {
                    System.out.print("Want to buy another PC?[y/n]: ");
                    String ans = sc.nextLine();
                    if (ans.equalsIgnoreCase("y")) {
                        handleOrder(pcs);
                    }
                }
            }
        }
        System.out.println("Exiting PC Manufacturing System:(");
    }
}
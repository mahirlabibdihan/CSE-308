package product;

import java.util.ArrayList;
import java.util.List;

import product.part.PCComponent;

public class PC {
    private List<PCComponent> base; // For CPU, MotherBoard, HDD
    private List<PCComponent> added; // For RAM, Graphics card...
    private Integer base_price;
    private Integer total_price;
    private String name;

    public PC(String name,Integer price) {
        this.name = name;
        base_price = total_price = price;
        base = new ArrayList<>();
        added = new ArrayList<>();
    }

    public void addBaseComponent(PCComponent comp) {
        base.add(comp);
    }

    public void addAdditionalComponent(PCComponent comp) {
        total_price += comp.getPrice();
        added.add(comp);
    }

    public void printReceipt() {
        System.out.println();
        System.out.println("Name: " + name);
        System.out.println("Base components: ");
        for (int i = 0; i < base.size(); i++) {
            System.out.println((i + 1) + ". " + base.get(i).getDetails());
        }
        System.out.println("Base price: " + base_price + " BDT");

        if (base_price < total_price) {
            System.out.println("Added components: ");
            for (int i = 0; i < added.size(); i++) {
                System.out.println((i + 1) + ". " + added.get(i).getDetails() + " - " + added.get(i).getPrice() + " BDT");
            }
        }
        System.out.println("Total price: " + total_price + " BDT");
        System.out.println();
    }
}

package com.dihu.client;

import com.dihu.context.VendingMachine;
import com.dihu.io.Console;

import java.util.Scanner;

// Insert money
// Confirm purchase/Get money back
// Get change
// Get product
public class Main {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();
        while (true) {
            // insert money or place order
            System.out.println();
            System.out.println("1. Insert money");
            System.out.println("2. Confirm purchase");
            System.out.println("3. Receive product");
            int option = Console.getOption(1, 3);
            switch (option) {
                case 1:
                    machine.insertMoney();
                    break;
                case 2:
                    machine.confirmPurchase();
                    break;
                case 3:
                    machine.releaseProduct();
                    break;
                default:
                    break;
            }
        }
    }
}
package com.dihu.state;

import com.dihu.context.VendingMachine;
import com.dihu.io.Console;

import java.util.Scanner;

public class HasMoneyState implements State {
    private VendingMachine machine;

    public HasMoneyState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertMoney() {
        System.out.println("Price per product: "+machine.getProduct().getPrice());
        System.out.println("Your balance: " + machine.getBalance() + " Tk");
        int amount = Console.getPositiveInt("Enter more amount: ");
        System.out.println("You inserted "+amount+" Tk");
        machine.setBalance(machine.getBalance()+amount);
    }

    @Override
    public void confirmPurchase() {
        System.out.println("You confirmed purchase");
        int diff = machine.getBalance() - machine.getProduct().getPrice();
        if (diff == 0) // Equal
        {
            Console.printSuccess("Your product is ready.");
            machine.setState(machine.getSoldState()); // DeliverState
        } else if (diff < 0) // Lower
        {
            Console.printError("Not enough money");
        } else // Higher
        {
            machine.setBalance(0);
            System.out.println("Returned amount: " + diff+" Tk");
            Console.printSuccess("Your product is ready.");
            machine.setState(machine.getSoldState()); // HigherAmountState
        }
    }

    @Override
    public void dispense() {
        Console.printWarning("You need to confirm purchase first");
    }
}

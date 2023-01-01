package com.dihu.state;

import com.dihu.context.VendingMachine;
import com.dihu.io.Console;

import java.util.Scanner;

public class NoMoneyState implements State {
    private VendingMachine machine;

    public NoMoneyState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertMoney() {
        System.out.println("Price per product: "+machine.getProduct().getPrice());
        int amount = Console.getPositiveInt("Enter amount: ");
        System.out.println("You inserted "+amount+" Tk");
        machine.setBalance(machine.getBalance()+amount);
        machine.setState(machine.getHasMoneyState());
    }

    @Override
    public void confirmPurchase() {
        Console.printError("You confirmed purchase, but there's no money");
    }

    @Override
    public void dispense() {
        Console.printWarning("You need to pay first");
    }
}

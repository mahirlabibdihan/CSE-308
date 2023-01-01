package com.dihu.state;

import com.dihu.context.VendingMachine;
import com.dihu.io.Console;

public class SoldState implements State {
    private VendingMachine machine;

    public SoldState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertMoney() {
        Console.printWarning("Receive previous product first");
    }

    @Override
    public void confirmPurchase() {
        Console.printWarning("You already confirmed the purchase. Receive the product.");
    }

    @Override
    public void dispense() {
        Console.printSuccess("Your product is released.");
        if (machine.getProduct().getCount() == 0) {
            machine.setState(machine.getSoldOutState());
        } else {
            machine.setState(machine.getInitialState());
        }
    }
}

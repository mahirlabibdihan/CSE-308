package com.dihu.state;

import com.dihu.context.VendingMachine;
import com.dihu.io.Console;

public class SoldOutState implements State {
    private VendingMachine machine;
    public SoldOutState(VendingMachine machine)
    {
        this.machine = machine;
    }

    @Override
    public void insertMoney() {
        Console.printError("Products sold out");
    }

    @Override
    public void confirmPurchase() {
        Console.printError("Products sold out");
    }

    @Override
    public void dispense() {
        Console.printError("Products sold out");
    }
}

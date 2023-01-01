package com.dihu.context;

import com.dihu.state.*;

public class VendingMachine {
    private int balance;
    private Product product;
    private HasMoneyState hasMoneyState;
    private NoMoneyState noMoneyState;
    private SoldState soldState;
    private SoldOutState soldOutState;
    private State state;

    public VendingMachine() {
        balance = 0;
        noMoneyState = new NoMoneyState(this);
        hasMoneyState = new HasMoneyState(this);
        soldState = new SoldState(this);
        soldOutState = new SoldOutState(this);

        product = new Product(100, 2);
        if (product.getCount() == 0) {
            this.state = soldOutState;
        } else {
            this.state = noMoneyState;
        }
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void insertMoney() {
        state.insertMoney();
    }

    public void confirmPurchase() {
        state.confirmPurchase();
    }

    public void releaseProduct() {
        product.setCount(Math.max(product.getCount() - 1, 0));
        state.dispense();
    }

    public NoMoneyState getInitialState() {
        return noMoneyState;
    }

    public HasMoneyState getHasMoneyState() {
        return hasMoneyState;
    }

    public SoldState getSoldState() {
        return soldState;
    }

    public SoldOutState getSoldOutState() {
        return soldOutState;
    }
}

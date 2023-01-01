package com.dihu.context;

public class Product {
    private int count;
    private int price;
    public Product(int price,int count)
    {
        this.price = price;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

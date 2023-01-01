package product.part.cpu;

import product.part.PCComponent;

public abstract class CPU extends PCComponent {
    protected String company;
    protected String category;

    protected CPU(String company, String category, Integer price){
        this.company = company;
        this.category = category;
        this.price = price;
        this.name = "CPU";
    }

    public String getCategory() {
        return category;
    }

    public String getCompany() {
        return company;
    }
}

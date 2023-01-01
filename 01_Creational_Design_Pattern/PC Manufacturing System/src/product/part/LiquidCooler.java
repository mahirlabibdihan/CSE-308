package product.part;

public class LiquidCooler  extends PCComponent{

    public LiquidCooler(Integer price) {
        this.price = price;
        this.name = "Liquid Cooler";
    }

    @Override
    public String getDetails() {
        return name;
    }
}

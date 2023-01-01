package product.part;

public class CPUCooler extends PCComponent {

    public CPUCooler(Integer price) {
        this.price = price;
        this.name = "CPU Cooler";
    }

    @Override
    public String getDetails() {
        return name;
    }

}

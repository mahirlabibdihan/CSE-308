package product.part;

public class RAM  extends PCComponent{
    private String frequency;
    private String type;
    private String size;

    public RAM(String size, String type, String frequency,Integer price){
        this.size = size;
        this.type = type;
        this.frequency = frequency;
        this.price = price;
        this.name = "RAM";
    }

    public String getFrequency() {
        return frequency;
    }

    public String getSize() {
        return size;
    }

    public String getType() {
        return type;
    }

    @Override
    public String getDetails() {
        return size+" "+type+" "+frequency+" "+name;
    }
}

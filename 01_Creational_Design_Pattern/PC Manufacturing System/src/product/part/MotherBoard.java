package product.part;

public class MotherBoard  extends PCComponent{
    public MotherBoard(){
        this.name = "Motherboard";
    }

    @Override
    public String getDetails() {
        return name;
    }
}

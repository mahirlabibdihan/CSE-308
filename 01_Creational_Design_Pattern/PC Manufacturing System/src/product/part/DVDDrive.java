package product.part;

public class DVDDrive  extends PCComponent{
    public DVDDrive(Integer price){
        this.price = price;
        this.name = "DVD Drive";
    }

    @Override
    public String getDetails() {
        return name;
    }
}

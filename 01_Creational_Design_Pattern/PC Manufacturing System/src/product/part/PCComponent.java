package product.part;

public abstract class PCComponent{
    protected String name;
    protected Integer price = 0;
    public String getName(){
        return name;
    }
    public abstract String getDetails();
    public Integer getPrice(){
        return price;
    }
}

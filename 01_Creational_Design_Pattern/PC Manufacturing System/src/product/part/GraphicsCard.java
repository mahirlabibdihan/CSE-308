package product.part;

public class GraphicsCard extends PCComponent {
    private String size;

    public GraphicsCard(String size, Integer price) {
        this.size = size;
        this.price = price;
        this.name = "Graphics Card";
    }
    public String getSize() {
        return size;
    }

    @Override
    public String getDetails() {
        return size + " " + name;
    }
}

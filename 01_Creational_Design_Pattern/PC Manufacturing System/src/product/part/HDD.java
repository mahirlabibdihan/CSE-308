package product.part;

public class HDD extends PCComponent {
    private String size;

    public HDD(String size) {
        this.size = size;
        this.name = "HDD";
    }

    public String getSize() {
        return size;
    }

    @Override
    public String getDetails() {
        return size + " " + name;
    }
}

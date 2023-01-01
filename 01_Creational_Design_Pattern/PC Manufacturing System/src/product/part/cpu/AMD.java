package product.part.cpu;

public class AMD extends CPU {
    // Category: Ryzen 9,7,5,3, Athlons
    // Model number: 5700X
    private String model;

    public AMD(String category, String model, Integer price) {
        super("AMD",category, price);
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String getDetails() {
        return company + " " + category + " " + model +" "+ name;
    }
}


// AMD: Company name
// Ryzen: Product family name
// Zen: Architecture name
// Ryzen 3600: 3-> Generation, 6->Model number

// Model number:
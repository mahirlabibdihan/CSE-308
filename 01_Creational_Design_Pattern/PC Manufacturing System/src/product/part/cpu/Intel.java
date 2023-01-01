package product.part.cpu;

public class Intel extends CPU {
    // Category: i9,i7,i5,i3,pentium,celeron
    // Generation: 11th generation
    private String generation;

    public Intel(String category, String generation, Integer price) {
        super("Intel", category, price);
        this.generation = generation;
    }

    public String getGeneration() {
        return generation;
    }

    @Override
    public String getDetails() {
        return company + " " + category + " " + generation + " generation " + name;
    }
}

package Product;

public class ProductSchema {
    private final String title;
    private final String description;
    private final String price;
    private final Integer rating;

    public ProductSchema(String title, String description, String price, Integer rating) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "ProductSchema{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", rating=" + rating +
                '}';
    }
}

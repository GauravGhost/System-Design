package Product;

public class Product {
    private final String title;
    private final String description;
    private final String price;
    private final Integer rating;

    public Product(String title, String description, String price, Integer rating) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", rating=" + rating +
                '}';
    }
}

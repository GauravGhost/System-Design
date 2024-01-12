package Product;

public class ProductBuilder implements Builder {
    private String title;
    private String description;
    private String price;
    private Integer rating;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public Integer getRating() {
        return rating;
    }

    @Override
    public ProductBuilder title(String title) {
        this.title = title;
        return this;
    }

    @Override
    public ProductBuilder description(String description) {
        this.description = description;
        return this;
    }

    @Override
    public ProductBuilder price(String price){
        this.price = price;
        return this;
    }

    @Override
    public ProductBuilder rating(Integer rating){
        this.rating = rating;
        return this;
    }



    public Product build() {
        return new Product(title, description, price, rating);
    }
}

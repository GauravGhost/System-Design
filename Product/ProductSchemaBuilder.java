package Product;

public class ProductSchemaBuilder implements Builder, Cloneable{
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
    public ProductSchemaBuilder title(String title) throws Exception {
        if(title.isEmpty()){
            System.out.println("please Enter title");
        }
        this.title = title;
        return this;
    }

    @Override
    public ProductSchemaBuilder description(String description) throws Exception {
        if(description.isEmpty()){
            throw new Exception("Please Enter Description");
        }
        this.description = description;
        return this;
    }

    @Override
    public ProductSchemaBuilder price(String price)  throws Exception{
        this.price = price;
        return this;
    }

    @Override
    public ProductSchemaBuilder rating(Integer rating) throws Exception {
        if(rating <= 0) {
            throw new Exception("Rating Cannot be less than 0");
        } else if (rating > 5){
            throw new Exception("Rating Cannot be more than 5");
        }
        this.rating = rating;
        return this;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public ProductSchema build() {
        return new ProductSchema(title, description, price, rating);
    }
}

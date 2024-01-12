import Product.ProductBuilder;
import Product.ProductSchemaBuilder;

public class Main {
    public static void main(String[] args) throws Exception {
        Director director = new Director();

        ProductSchemaBuilder productSchemaBuilder = new ProductSchemaBuilder();

        director.buildSmartphone(productSchemaBuilder);
        productSchemaBuilder.price("23334").rating(5);
        System.out.println(productSchemaBuilder.build());

        ProductBuilder productBuilder = new ProductBuilder();

        director.buildProduct(productSchemaBuilder, productBuilder);
        System.out.println(productBuilder.build());
    }
}

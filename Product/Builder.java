package Product;

public interface Builder {
    Builder title(String title) throws Exception;
    Builder description(String description) throws Exception;
    Builder price(String price) throws Exception;
    Builder rating(Integer rating) throws Exception;
}

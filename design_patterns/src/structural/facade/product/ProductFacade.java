package structural.facade.product;

public class ProductFacade {
    private String type;

    public ProductFacade(String type) {
        this.type = type;
    }

    public void action() {
        Product product = switch (type) {
            case "food" -> new FoodProduct();
            case "clothes" -> new ClothesProduct();
            default -> new PhysicalProduct();
        };

        product.action();
    }
}

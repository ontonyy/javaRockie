package creational.builder.computer.components;

public class Mouse {
    private String manufacturer;

    public Mouse(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void move() {
        System.out.println("Mouse moving process");
    }

    @Override
    public String toString() {
        return "Mouse{" +
                "manufacturer='" + manufacturer + '\'' +
                '}';
    }
}

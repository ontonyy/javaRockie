package creational.factory.coffee;

public class SimpleCoffeeFactory {

    public Coffee createCoffee(CoffeeType type) {
        Coffee coffee = null;

        switch (type) {
            case ESPRESSO -> coffee = new Espresso();
            case AMERICANO -> coffee = new Americano();
            case CAPPUCCINO -> coffee = new Cappuccino();
            case CAFFE_LATTE -> coffee = new CaffeLatte();
        }

        return coffee;
    }

}

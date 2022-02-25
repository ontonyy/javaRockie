package patterns.FactoryMethod.CoffeeFactoryMethod;

import patterns.Factory.CoffeeFactory.CoffeeType;

public class ItalianCoffeeShop extends CoffeeShop {
    @Override
    protected Coffee createCoffee(CoffeeType type) {
        Coffee coffee = null;

        switch (type) {
            case AMERICANO -> coffee = new ItalianAmericano();
            case ESPRESSO -> coffee = new ItalianEspresso();
            case CAFFE_LATTE -> coffee = new ItalianCaffeLatte();
            case CAPPUCCINO -> coffee = new ItalianCappuccino();
        }

        return coffee;
    }
}

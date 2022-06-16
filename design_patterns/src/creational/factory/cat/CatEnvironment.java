package creational.factory.cat;

public class CatEnvironment {

    private final CatFactory catFactory;

    public CatEnvironment(CatFactory catFactory) {
        this.catFactory = catFactory;
    }

    public Cat catWalking(CatType type) {
        Cat cat = catFactory.createCat(type);

        if (cat != null) {
            cat.wakeUp();
            cat.move();
            cat.bark();
        }

        System.out.println("Your cat is walking!");
        return cat;
    }

}

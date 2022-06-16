package creational.factory.cat;

public class CatFactory {

    public Cat createCat(CatType type) {
        Cat cat = null;

        switch (type) {
            case LION -> cat = new Lion();
            case TIGER -> cat = new Tiger();
            case BARSIK -> cat = new Barsik();
        }

        return cat;
    }

}

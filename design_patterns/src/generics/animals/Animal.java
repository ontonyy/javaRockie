package generics.animals;

public abstract class Animal implements Comparable<Animal> {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void eat();
    public abstract void walk();

    @Override
    public int compareTo(Animal o) {
        return Integer.compare(name.length(), o.getName().length());
    }
}

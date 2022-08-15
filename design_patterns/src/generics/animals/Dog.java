package generics.animals;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.printf("Dog(%s) eating", name);
    }

    @Override
    public void walk() {
        System.out.printf("Dog(%s) walking", name);
    }

    @Override
    public String toString() {
        return String.format("Dog(%s)", name);
    }
}

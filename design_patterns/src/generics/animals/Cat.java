package generics.animals;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.printf("Cat(%s) eating", getName());
    }

    @Override
    public void walk() {
        System.out.printf("Cat(%s) walking", getName());
    }

    @Override
    public String toString() {
        return String.format("Cat(%s)", name);
    }
}

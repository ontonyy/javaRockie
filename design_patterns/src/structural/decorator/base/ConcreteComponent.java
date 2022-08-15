package structural.decorator.base;

public class ConcreteComponent implements Component {
    @Override
    public void execute() {
        System.out.println("Concrete executing...");
    }
}

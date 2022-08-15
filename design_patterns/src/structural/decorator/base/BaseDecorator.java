package structural.decorator.base;

public class BaseDecorator implements Component {
    private Component wrappee;

    public BaseDecorator(Component wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void execute() {
        System.out.println("Base decorator executing...");
        wrappee.execute();
    }
}

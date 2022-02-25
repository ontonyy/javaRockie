package patterns.Bridge;

public interface Color {
    void fillColor();
}

class RedColor implements Color {

    @Override
    public void fillColor() {
        System.out.println("Now I am red!");
    }
}

class GreenColor implements Color {

    @Override
    public void fillColor() {
        System.out.println("Now I am green!");
    }
}

class BlackColor implements Color {

    @Override
    public void fillColor() {
        System.out.println("Now I am black!");
    }
}

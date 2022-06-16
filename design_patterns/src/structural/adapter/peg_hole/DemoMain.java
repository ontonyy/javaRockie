package structural.adapter.peg_hole;

public class DemoMain {
    public static void main(String[] args) {
        RoundHole hole = new RoundHole(10);
        RoundPeg roundPeg = new RoundPeg(5);
        System.out.println(hole.fits(roundPeg));

        SquarePeg squarePeg = new SquarePeg(20);
        SquarePegAdapter adapter = new SquarePegAdapter(squarePeg);

        System.out.println(hole.fits(adapter));

    }
}

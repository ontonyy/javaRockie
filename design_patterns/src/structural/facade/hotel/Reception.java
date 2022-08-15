package structural.facade.hotel;

public class Reception implements HotelAnnex {
    @Override
    public void act() {
        System.out.println("People get info about hotel here.");
    }

    @Override
    public String getType() {
        return "Reception";
    }
}

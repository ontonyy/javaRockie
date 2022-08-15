package structural.facade.hotel;

public class Restaurant implements HotelAnnex {
    @Override
    public void act() {
        System.out.println("People eat here.");
    }

    @Override
    public String getType() {
        return "Restaurant";
    }
}

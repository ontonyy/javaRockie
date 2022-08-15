package structural.facade.hotel;

public class WaterPool implements HotelAnnex {
    @Override
    public void act() {
        System.out.println("People swim here.");
    }

    @Override
    public String getType() {
        return "Water pool";
    }
}

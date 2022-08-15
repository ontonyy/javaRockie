package structural.facade.hotel;

public class HotelKeeper {
    public void act(String format) {
        HotelAnnex annex = switch (format) {
            case "pool" -> new WaterPool();
            case "restaurant" -> new Restaurant();
            default -> new Reception();
        };
        annex.act();
    }
}

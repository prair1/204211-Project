package AppModel;

import java.nio.charset.StandardCharsets;

public class Price {
    private byte[] Name;
    private double PriceKids;
    private double PriceAdult;

    public Price(byte[] name, double priceKids, double priceAdult) {
        Name = name;
        PriceKids = priceKids;
        PriceAdult = priceAdult;
    }

    public String getName() {
        return new String(Name, StandardCharsets.UTF_8);
    }

    public double getPriceKids() {
        return PriceKids;
    }

    public double getPriceAdult() {
        return PriceAdult;
    }
}

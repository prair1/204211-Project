package AppModel;

public class Price {
    private String Name;
    private double PriceKids;
    private double PriceAdult;

    public Price(String name, double priceKids, double priceAdult) {
        Name = name;
        PriceKids = priceKids;
        PriceAdult = priceAdult;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getPriceKids() {
        return PriceKids;
    }

    public void setPriceKids(double priceKids) {
        PriceKids = priceKids;
    }

    public double getPriceAdult() {
        return PriceAdult;
    }

    public void setPriceAdult(double priceAdult) {
        PriceAdult = priceAdult;
    }
}

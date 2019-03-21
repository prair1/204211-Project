package AppModel;

public class Price {
    private String Name;
    private int PriceKids;
    private int PriceAdult;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPriceKids() {
        return PriceKids;
    }

    public void setPriceKids(int priceKids) {
        PriceKids = priceKids;
    }

    public int getPriceAdult() {
        return PriceAdult;
    }

    public void setPriceAdult(int priceAdult) {
        PriceAdult = priceAdult;
    }
}

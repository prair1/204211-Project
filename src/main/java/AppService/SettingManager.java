package AppService;

import AppModel.Price;
import AppUtil.Lang;

import java.util.HashMap;

public class SettingManager {

    private static SettingManager ourInstance = new SettingManager();

    public static SettingManager getInstance() {
        return ourInstance;
    }

    private Lang language;
    private int TableCount;
    private long TimeLimit;
    private long TimeExcess;
    private int ExcessFine;
    private int ServiceCharge;
    private boolean SeperateKA;
    private HashMap<String, Price> PriceMap = new HashMap<>();

    private SettingManager() {
        //TODO: Load settings from file
    }

    //region getter setter
    public Lang getLanguage() {
        return language;
    }

    public void setLanguage(Lang language) {
        this.language = language;
    }

    public int getTableCount() {
        return TableCount;
    }

    public void setTableCount(int tableCount) {
        TableCount = tableCount;
    }

    public long getTimeLimit() {
        return TimeLimit;
    }

    public void setTimeLimit(long timeLimit) {
        TimeLimit = timeLimit;
    }

    public long getTimeExcess() {
        return TimeExcess;
    }

    public void setTimeExcess(long timeExcess) {
        TimeExcess = timeExcess;
    }

    public int getExcessFine() {
        return ExcessFine;
    }

    public void setExcessFine(int excessFine) {
        ExcessFine = excessFine;
    }

    public int getServiceCharge() {
        return ServiceCharge;
    }

    public void setServiceCharge(int serviceCharge) {
        ServiceCharge = serviceCharge;
    }

    public boolean isSeperateKA() {
        return SeperateKA;
    }

    public void setSeperateKA(boolean seperateKA) {
        SeperateKA = seperateKA;
    }

    public Price getPrice(String name) {
        return PriceMap.get(name);
    }

    public void addPrice(Price newPrice) {
        PriceMap.put(newPrice.getName(), newPrice);
    }

    public void delPrice(String name) {
        PriceMap.remove(name);
    }
    //endregion
}

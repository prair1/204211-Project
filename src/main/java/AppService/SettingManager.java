package AppService;

import AppModel.Price;
import AppUtil.FilePath;
import AppUtil.Lang;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class SettingManager{

    private static SettingManager ourInstance = new SettingManager();

    public static SettingManager i() {
        return ourInstance;
    }

    static void setInstance(SettingManager newInstance) {
        ourInstance = newInstance;
    }

    private SettingManager() {}

    private Lang Language = Lang.English;
    private int TableCount;
    private boolean LimitTime;
    private long TimeLimit;
    private long TimePerExcess;
    private double ExcessFine;
    private double ServiceCharge;
    private LinkedHashMap<String, Price> PriceMap = new LinkedHashMap<>();


    private void updateFile() {
        SaverAndLoader.saveTo(SettingManager.i(), FilePath.SETTING.path, true);

    }

    //region getter setter

    public Lang getLanguage() {
        return Language;
    }

    public void setLanguage(Lang language) {
        Language = language;
        updateFile();
    }

    public int getTableCount() {
        return TableCount;
    }

    public void setTableCount(int tableCount) {
        TableCount = tableCount;
        updateFile();
    }

    public long getTimeLimit() {
        return TimeLimit;
    }

    public void setTimeLimit(long timeLimit) {
        TimeLimit = timeLimit;
        updateFile();
    }

    public long getTimePerExcess() {
        return TimePerExcess;
    }

    public void setTimePerExcess(long timeExcess) {
        TimePerExcess = timeExcess;
        updateFile();
    }

    public double getExcessFine() {
        return ExcessFine;
    }

    public void setExcessFine(double excessFine) {
        ExcessFine = excessFine;
        updateFile();
    }

    public double getServiceCharge() {
        return ServiceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        ServiceCharge = serviceCharge;
        updateFile();
    }

    public boolean isLimitTime() {
        return LimitTime;
    }

    public void setLimitTime(boolean limitTime) {
        LimitTime = limitTime;
    }

    public LinkedHashMap<String, Price> getPriceMap() {
        return PriceMap;
    }
    public double getPriceAdult(String name) {
        return PriceMap.get(name).getPriceAdult();
    }

    public double getPriceKids(String name) {
        return PriceMap.get(name).getPriceKids();
    }

    public void addPrice(String name, double priceKids, double priceAdult) {
        Price newPrice = new Price(name, priceKids, priceAdult);
        PriceMap.put(newPrice.getName(), newPrice);
        updateFile();
    }

    public void delPrice(String name) {
        PriceMap.remove(name);
        updateFile();
    }
    //endregion
}

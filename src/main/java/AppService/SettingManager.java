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
    private long TimeLimit;
    private long TimeExcess;
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

    public long getTimeExcess() {
        return TimeExcess;
    }

    public void setTimeExcess(long timeExcess) {
        TimeExcess = timeExcess;
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

    public Price getPrice(String name) {
        return PriceMap.get(name);
    }

    public void addPrice(Price newPrice) {
        PriceMap.put(newPrice.getName(), newPrice);
        updateFile();
    }

    public void delPrice(String name) {
        PriceMap.remove(name);
        updateFile();
    }
    //endregion
}

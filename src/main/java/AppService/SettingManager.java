package AppService;

import AppModel.Price;
import AppUtil.FilePath;
import AppUtil.Lang;

import java.util.HashMap;

public class SettingManager {

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
    private long TimeLimit = 100;
    private long TimeExcess = 10;
    private double ExcessFine = 50;
    private double ServiceCharge;
    private boolean SeparateKA;
    private HashMap<String, Price> PriceMap = new HashMap<>();


    private void updateFile() {
        SaverAndLoader.saveTo(SettingManager.i(), FilePath.SETTING.path, true);

    }

    //region getter setter

    public Lang getLanguage() {
        return Language;
    }

    public void setLanguage(Lang language) {
        Language = language;
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

    public double getExcessFine() {
        return ExcessFine;
    }

    public void setExcessFine(double excessFine) {
        ExcessFine = excessFine;
    }

    public double getServiceCharge() {
        return ServiceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        ServiceCharge = serviceCharge;
    }

    public boolean isSeparateKA() {
        return SeparateKA;
    }

    public void setSeperateKA(boolean separateKA) {
        SeparateKA = separateKA;
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

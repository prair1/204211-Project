package AppService;

import AppModel.Table;
import AppModel.TableActive;
import AppModel.TableBooking;

import java.time.LocalDateTime;
import java.util.*;

public class TableManager {

    private static TableManager ourInstance = new TableManager();
    private Random random = new Random();
    LinkedHashMap<Integer, TableActive> tableActives = new LinkedHashMap<>();
    LinkedHashMap<Integer, TableBooking> tableBookings = new LinkedHashMap<>();


    private TreeSet<Integer> tableNumSet = new TreeSet<>();

    private TableManager() {

        reloadTableNum();
    }

    public void updateFile() {
        ArrayList<TableActive> saveActive = new ArrayList<>();
        for (TableActive tab: tableActives.values())
            saveActive.add(tab);
        SaverAndLoader.saveTo(saveActive.toArray(), "tableActives.json");

        ArrayList<TableBooking> saveBooking = new ArrayList<>();
        for (TableBooking tab: tableBookings.values())
            saveBooking.add(tab);
        SaverAndLoader.saveTo(saveBooking.toArray(), "tableBookings.json");
    }

    public void getFile() {
        try {
            for (TableActive table : SaverAndLoader.tableGetFromAct("tableActives.json")) {
                tableNumSet.remove(table.getTableNum());
                tableActives.put(table.getId(), table);
            }
            for (TableBooking table : SaverAndLoader.tableGetFromBook("tableBookings.json")) {
                tableNumSet.remove(table.getTableNum());
                tableBookings.put(table.getId(), table);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void setInstance(TableManager newInstance) {
        ourInstance = newInstance;
        TableManager.i().reloadTableNum();
    }

    public void reloadTableNum() {
        tableNumSet.clear();
        for (int i = 1; i <= SettingManager.i().getTableCount(); i++)
            tableNumSet.add(i);
        for (Map.Entry<Integer, TableActive> table: tableActives.entrySet()) {
            tableNumSet.remove(table.getValue().getTableNum());
        }
        for (Map.Entry<Integer, TableBooking> table: tableBookings.entrySet()) {
            tableNumSet.remove(table.getValue().getTableNum());
        }
    }

    public static TableManager i() {
        return ourInstance;
    }

    public void newTableActive(int tableNum, String course, int kidsNumber, int adultNumber) {
        tableNumSet.remove(tableNum);
        TableActive table = new TableActive(genId(), tableNum, course, kidsNumber, adultNumber);
        tableActives.put(table.getId(), table);
        updateFile();
    }

    public void newTableBooking(int tableNum, String course, String customerName,int kidsNumber, int adultNumber, LocalDateTime timeCheckin) {
        tableNumSet.remove(tableNum);
        TableBooking table = new TableBooking(genId(), tableNum, course, kidsNumber, adultNumber, timeCheckin, customerName);
        tableBookings.put(table.getId(), table);
        updateFile();
    }

    public void delTableActive(int id) {
        tableNumSet.add(tableActives.get(id).getTableNum());
        tableActives.remove(id);
        updateFile();
    }

    public void delTableBooking(int id) {
        tableNumSet.add(tableBookings.get(id).getTableNum());
        tableBookings.remove(id);
        updateFile();
    }

    public Table findById(int id) {
        Table table = null;
        if (tableActives.containsKey(id)) {
            table = tableActives.get(id);
        }
        if (tableBookings.containsKey(id)) {
            table = tableBookings.get(id);
        }
        return table;
    }

    public void startTable(int id) {
        TableBooking table = tableBookings.get(id);
        tableBookings.remove(id);
        tableActives.put(table.getId(), table.toActive());
        updateFile();
    }

    public LinkedHashMap<Integer, TableActive> getTableActives() {
        return tableActives;
    }

    public LinkedHashMap<Integer, TableBooking> getTableBookings() {
        return tableBookings;
    }

    public TreeSet<Integer> getTableNumSet() {
        return tableNumSet;
    }

    public int genId() {
        return random.nextInt() + random.nextInt() + random.nextInt();
    }

    public void clockUpdate() {
        for (TableActive table: tableActives.values()) {
            table.updateTime();
        }
        for (TableBooking table: tableBookings.values()) {
            table.updateTime();
        }
    }
}

package AppService;

import AppModel.Table;
import AppModel.TableActive;
import AppModel.TableBooking;
import java.time.LocalDateTime;
import java.util.*;

import static AppUtil.Converter.byteName;

public class TableManager {

    private static TableManager ourInstance = new TableManager();
    private Random random = new Random();
    private LinkedHashMap<Integer, TableActive> tableActives = new LinkedHashMap<>();
    private LinkedHashMap<Integer, TableBooking> tableBookings = new LinkedHashMap<>();

    private TreeSet<Integer> tableNumSet = new TreeSet<>();

    private TableManager() {
        reloadTableNum();
    }

    public void reloadTableNum() {
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

    public int newTableActive(int tableNum, String type, int kidsHeads, int adultHeads) {
        tableNumSet.remove(tableNum);
        TableActive table = new TableActive(genId(), tableNum, type, kidsHeads, adultHeads);
        tableActives.put(table.getId(), table);
        return table.getId();
    }

    public int newTableBooking(int tableNum, String type, String customerName,int kidsHeads, int adultHeads, LocalDateTime timeCheckin) {
        tableNumSet.remove(tableNum);
        TableBooking table = new TableBooking(genId(), tableNum, type, kidsHeads, adultHeads, timeCheckin, customerName);
        tableBookings.put(table.getId(), table);
        return table.getId();
    }

    public void delTableActive(int id) {
        tableActives.remove(id);
    }

    /*public int delTableBooking(int tableNum) {

    }*/

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
}

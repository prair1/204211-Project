package AppService;

import AppModel.TableActive;
import AppModel.TableBooking;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Random;

public class TableManager {

    private static TableManager ourInstance = new TableManager();
    Random random = new Random();
    LinkedHashMap<Integer, TableActive> tableActives = new LinkedHashMap<>();
    LinkedHashMap<Integer, TableBooking> tableBookings = new LinkedHashMap<>();

    private TableManager() {
    }

    public static TableManager i() {
        return ourInstance;
    }

    public int newTableActive(int tableNum, String type, int kidsHeads, int adultHeads) {
        TableActive table = new TableActive(genId(), tableNum, type, kidsHeads, adultHeads);
        tableActives.put(table.getId(), table);
        return table.getId();
    }

    public int newTableBooking(int tableNum, String type, String customerName,int kidsHeads, int adultHeads, LocalDateTime timeCheckin) {
        TableBooking table = new TableBooking(genId(), tableNum, type, kidsHeads, adultHeads, timeCheckin, customerName);
        tableBookings.put(table.getId(), table);
        return table.getId();
    }

    public int genId() {
        return random.nextInt() + random.nextInt() + random.nextInt();
    }
}

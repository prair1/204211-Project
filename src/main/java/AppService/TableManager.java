package AppService;

import AppModel.TableActive;
import AppModel.TableBooking;

import java.util.ArrayList;

public class TableManager {
    private static TableManager ourInstance = new TableManager();

    public static TableManager i() {
        return ourInstance;
    }

    private TableManager() { }

    ArrayList<TableActive> tableActives = new ArrayList<>();
    ArrayList<TableBooking> tableBookings = new ArrayList<>();
}

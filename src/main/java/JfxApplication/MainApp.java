package JfxApplication;

import AppModel.Table;
import AppModel.TableActive;
import AppService.Logger;
import AppService.SaverAndLoader;
import AppService.SettingManager;
import AppUtil.FilePath;

import java.io.File;
import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.SECONDS;

public class MainApp {
    public static void main(String[] args) {
        File directory = new File(SaverAndLoader.getFile(""));
        if (! directory.exists()){
            if (directory.mkdirs()) {
                SaverAndLoader.saveTo(SettingManager.i(), FilePath.SETTING.path, true);
            }
        }
        //SaverAndLoader.getFrom(SettingManager.i(), FilePath.SETTING.path);
        Logger.i();
        Table tab = new TableActive(0, 1, "adfa", 12, 13214);
        tab.TimeFinished = LocalDateTime.now().plus(111, SECONDS);
        AppLoader.main(args);
    }
}

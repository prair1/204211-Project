package JfxApplication;

import AppService.Logger;
import AppService.SaverAndLoader;
import AppService.SettingManager;
import AppUtil.FilePath;

import java.io.File;

public class MainApp {
    public static void main(String[] args) {
        File directory = new File(SaverAndLoader.getFile(""));
        if (! directory.exists()){
            if (directory.mkdirs()) {
                SaverAndLoader.saveTo(SettingManager.i(), FilePath.SETTING.path, true);
            }
        }
        SaverAndLoader.getFrom(SettingManager.i(), FilePath.SETTING.path);
        Logger.i();

        AppLoader.main(args);
    }
}

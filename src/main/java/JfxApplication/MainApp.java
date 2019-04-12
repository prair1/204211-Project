package JfxApplication;

import AppService.Logger;
import AppService.SaverAndLoader;
import AppService.SettingManager;
import AppUtil.FilePath;

import java.io.File;

public class MainApp {
    public static void main(String[] args) {
        // region The initialize
        File directory = new File(SaverAndLoader.getFile(""));
        if (! directory.exists()){
            if (directory.mkdirs()) {
                SaverAndLoader.saveTo(SettingManager.i(), FilePath.SETTING.path, true);
            }
        }
        // endregion
        SaverAndLoader.getFrom(FilePath.SETTING.path);
        Logger.i();

        AppLoader.main(args);
    }
}

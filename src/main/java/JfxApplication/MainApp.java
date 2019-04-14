package JfxApplication;

import AppService.*;

import java.io.File;

public class MainApp {
    public static void main(String[] args) {
        // region The initialize
        File directory = new File(SaverAndLoader.getFile(""));
        if (! directory.exists()){
            if (directory.mkdirs()) {
                SaverAndLoader.saveTo(SettingManager.i(), "settings.json");
            }
        }
        // endregion
        SaverAndLoader.getFrom("settings.json");
        TableManager.i();
        Logger.i();
        AppLoader.main(args);
    }
}

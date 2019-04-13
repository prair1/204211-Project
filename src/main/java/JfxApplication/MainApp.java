package JfxApplication;

import AppService.*;
import AppUtil.FilePath;

import java.io.File;

public class MainApp {
    public static void main(String[] args) {
        // region The initialize
        File directory = new File(SaverAndLoader.getFile(""));
        if (! directory.exists()){
            if (directory.mkdirs()) {
                SaverAndLoader.saveTo(SettingManager.i(), FilePath.SETTING.path);
            }
        }
        // endregion
        SaverAndLoader.getFrom(FilePath.SETTING.path);
        Logger.i();
        for (int i = 0; i< 10; i++)
            System.out.println(TableManager.i().genId());

        AppLoader.main(args);
    }
}

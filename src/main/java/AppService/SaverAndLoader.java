package AppService;

import AppUtil.FilePath;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class SaverAndLoader {

    public static String getFile(String fileName) {
        return Paths.get(System.getProperty("user.dir"), "save", fileName).toString();
    }

    public static void getFrom(String file) {
        Gson gson = new Gson();
        FileReader reader;
        try {
            if (file.contentEquals(FilePath.SETTING.path)) {
                reader = new FileReader(getFile(file));
                SettingManager.setInstance(gson.fromJson(reader, SettingManager.class));
            }
            else if (file.contentEquals(FilePath.TABLE.path)) {
                // TODO
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void saveTo(Object object, String file, boolean prettyPrint) {
        Gson gson;
        if (prettyPrint)
            gson = new GsonBuilder().setPrettyPrinting().create();
        else
            gson = new Gson();

        FileWriter writer;
        try {
            writer = new FileWriter(getFile(file));
            gson.toJson(object, writer);
            writer.flush();
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

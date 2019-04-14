package AppUtil;

import java.nio.charset.StandardCharsets;

public class Converter {
    public static byte[] byteName(String name) {
        return name.getBytes(StandardCharsets.UTF_8);
    }

    public static String byteNameConc(byte[] bname) {
        String[] strArray = new String[bname.length];

        for (int i = 0; i < bname.length; i++)
            strArray[i] = String.valueOf(bname[i]);
        return String.join("", strArray);
    }

    public static String strFromByte(byte[] name) {
        return new String(name, StandardCharsets.UTF_8);
    }
}

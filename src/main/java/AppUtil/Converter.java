package AppUtil;

import java.nio.charset.StandardCharsets;

public class Converter {
    public static byte[] byteName(String name) {
        return name.getBytes(StandardCharsets.UTF_8);
    }

    public static String byteNameConc(byte[] bName) {
        String[] strArray = new String[bName.length];

        for (int i = 0; i < bName.length; i++)
            strArray[i] = String.valueOf(bName[i]);
        return String.join("", strArray);
    }

    public static String strFromByte(byte[] name) {
        return new String(name, StandardCharsets.UTF_8);
    }

    public static long[] sepTime(long second) {
        long hour = second / 3600;
        second = second - hour * 3600;
        long min = second / 60;
        second = second - min * 60;
        return new long[]{hour, min, second};
    }
}

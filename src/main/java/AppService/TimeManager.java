package AppService;

import AppUI.FXMLControllerMain;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class TimeManager {
    private static TimeManager ourInstance = new TimeManager();

    Timeline clock;

    public static TimeManager i() {
        return ourInstance;
    }

    private TimeManager() {
        clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            FXMLControllerMain.clockUpdate();
        }), new KeyFrame(Duration.millis(500)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    public static long strToSecond(String hour, String minute, String second) {
        return (Long.parseLong(hour) * 3600) + (Long.parseLong(minute) * 60) + Long.parseLong(second);
    }

    public static String[] secondToStr(long second) {
        long[] time = sepTime(second);
        return new String[] {String.valueOf(time[0]), String.valueOf(time[1]), String.valueOf(time[2])};
    }

    public static long[] sepTime(long second) {
        long hour = second / 3600;
        second = second - hour * 3600;
        long min = second / 60;
        second = second - min * 60;
        return new long[] {hour, min, second};
    }
}

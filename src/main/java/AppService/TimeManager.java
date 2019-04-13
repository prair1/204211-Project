package AppService;

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
            //todo
        }), new KeyFrame(Duration.millis(500)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }
}

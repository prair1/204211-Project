package AppUtil;

import AppService.SettingManager;

public enum Text {
    //SETUP
    START("เริ่ม", "Start"),
    //SETTING
    /*SETTING(),
    LANGUAGE(),
    TABLE(),
    TIMELIMIT(),
    HOUR(),
    MIN(),
    SEC(),
    EXCESSFINE(),
    PER(),
    SERVICECHARGE();*/;


    private final String THTxt;
    private final String ENTxt;

    public String get() {
        if (SettingManager.i().getLanguage() == Lang.Thai)
            return THTxt;
        else
            return ENTxt;
    }

    Text(String THTxt, String ENTxt) {
        this.THTxt = THTxt;
        this.ENTxt = ENTxt;
    }
}

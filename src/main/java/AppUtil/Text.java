package AppUtil;

import AppService.SettingManager;

public enum Text {
    START("เริ่ม", "Start");

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

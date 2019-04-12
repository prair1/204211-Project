package AppUtil;

import AppService.SettingManager;

public enum Text {
    //SETUP
    START("เริ่มต้น", "Start"),
    //SETTING
    SETTING( "ตั้งค่า","Setting"),
    LANGUAGE("ภาษา","Language"),
    TABLE("จำนวนโต๊ะ", "Amount of table"),
    TIMELIMIT("จำกัดเวลา", "Time limit"),
    HOUR("ชั่วโมง", "Hour"),
    MIN("นาที", "Min"),
    SEC("วินาที", "Sec"),
    EXCESSFINE("ค่าปรับ", "Excess fine"),
    PER("ต่อ", "Per"),
    SERVICECHARGE("ค่าบริการ", "Service charge"),
    COURSE("คอร์ส","Course"),
    ADULT("ผู้ใหญ","Adult"),
    KID("เด็ก","Kid"),
    PRICE("ราคา", "Price");






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

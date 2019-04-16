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
    MIN("นาที", "Minute"),
    SEC("วินาที", "Second"),
    EXCESSFINE("ค่าปรับ", "Excess fine"),
    PER("ต่อ", "Per"),
    SERVICECHARGE("ค่าบริการ", "Service charge"),
    COURSE("คอร์ส","Course"),
    PRICE("ราคา", "Price"),
    ADULT("ผู้ใหญ","Adult"),
    KID("เด็ก","Kid"),
    BACK("กลับ", "Back"),
    SAVE("เซฟ","Save"),
    MSG_EMPTY("ใส่ให้ครบดิวะ","It's fucking empty"),
    MSG_NOC("ไม่มีราคาอาหารอะสัส","Enter course pls"),
    MSG_EMPNOC("ใส่ให้ครบดิวะ และ ไม่มีราคาอาหารอะสัส","It's fucking empty and Enter course pls"),
    MSG_SUCCESS("เซฟ เสร็จ","Save Success"),
    // Table text
    BOOK_REMAIN("เหลืออีก %s", "%s\nremaining"),
    BOOK_EXCESS("เกินมา %s", "%s\nexcess"),
    ACTIVE_REMAIN("เหลืออีก %s", "%s\nremaining"),
    ACTIVE_EXCESS("เกินมา %s", "%s\nexcess"),
    ACTIVE_ELAPSED("ผ่านไป %s", "%s\nelapsed"),
    // Main
    MAIN("หน้าหลัก","Home"),
    ACTIVE("กำลังใช้งาน","Active"),
    BOOKING("จอง","Booking"),
    // Sub page
    TTABLE("โต๊ะ","Table"),
    NAME("ชื่อ","Name"),
    AMOUNT("จำนวน","Amount"),
    TIME("เวลา","Time"),
    CANCEL("ยกเลิก","Cancel"),
    TOACTIVE("เริ่ม","Start"),
    OK("ตกลง","OK"),
    FINE("ค่าปรับ","Fine"),
    OTHER("อื่นๆ","Other"),
    TOTAL("ยอดสุทธิ","Total"),
    STOP("คิดเงิน","Check bill"),
    END("ออก","Exit"),
    ERR_PEMPTY("กรุณากรอกข้อมูลให้ครบ","Please fill in the information"),
    ERR_TIMEIN("กรุณากรอกข้อมูลให้ครบ", "Please fill in the information"),
    ERR_MUL("กรุณากรอกข้อมูลให้ครบ" ,"Please fill in the information"),
    ERR_TEMPTY("กรุณากรอกข้อมูลให้ครบ","Please fill in the information");

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

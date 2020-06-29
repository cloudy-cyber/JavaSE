package club.banyuan.June29.HomeWork;

public enum WeekDay {
    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期日"),
    ;

    private final String name;

    WeekDay(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean isWeekDay(String name) {
        if (!this.name.equals(SATURDAY.name) && !this.name().equals(SUNDAY.name)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isHoliday(String name) {
        if (this.name.equals(SATURDAY.name) || this.name.equals(SUNDAY.name)) {
            return true;
        } else {
            return false;
        }
    }


}
